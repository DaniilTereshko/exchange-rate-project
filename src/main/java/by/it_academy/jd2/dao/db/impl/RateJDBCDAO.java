package by.it_academy.jd2.dao.db.impl;

import by.it_academy.jd2.core.dto.RateDTO;
import by.it_academy.jd2.core.dto.RateRequestCreatorDTO;
import by.it_academy.jd2.core.dto.RateRequestDTO;
import by.it_academy.jd2.dao.api.IRateDAO;
import by.it_academy.jd2.dao.db.ds.DatabaseConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

public class RateJDBCDAO implements IRateDAO {
    @Override
    public List<RateDTO> get() {
        return null;
    }

    @Override
    public List<RateDTO> save(List<RateDTO> dtos) {
        try(Connection connection = DatabaseConnectionFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO app.currency_exchange_rate(currency_id, currency_cost, date_exchange_rate)" +
                    "VALUES(?, ?, ?) ON CONFLICT ON CONSTRAINT currency_exchange_rate_currency_id_date_exchange_rate_key DO NOTHING;");){
            for (RateDTO rateDTO:dtos){
                statement.setObject(1, rateDTO.getCurrencyID());
                statement.setBigDecimal(2, rateDTO.getCurrencyCost());
                statement.setObject(3, rateDTO.getDateExchangeRate());
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка вставки", e);
        }
        return dtos;

    }
    @Override
    public List<RateDTO> get(RateRequestDTO rateRequestDTO) {
        List<RateDTO> rateDTOList = new ArrayList<>();
        try (Connection conn = DatabaseConnectionFactory.getConnection();
             PreparedStatement st = conn.prepareStatement("SELECT currency_id, currency_cost, date_exchange_rate, CAST(is_day_off AS boolean)\n" +
                     "FROM app.currency_exchange_rate cer JOIN app.weekends w ON cer.date_exchange_rate = w.calendar_date \n" +
                     "WHERE date_exchange_rate BETWEEN SYMMETRIC ? AND ?\n" +
                     "AND currency_id = ?;");
        ){
            st.setObject(1,rateRequestDTO.getStartDate());
            st.setObject(2,rateRequestDTO.getEndDate());
            st.setInt(3,rateRequestDTO.getId());
            try (ResultSet rs = st.executeQuery();) {
                while (rs.next()) {
                    rateDTOList.add(new RateDTO(rs.getInt("currency_id"),rs.getBigDecimal("currency_cost"), rs.getDate("date_exchange_rate").toLocalDate().atStartOfDay(), rs.getBoolean("is_day_off")));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rateDTOList;
    }

    @Override
    public List<RateDTO> get(Integer currencyId) {
        List<RateDTO> rateDTOList = new ArrayList<>();
        try (Connection conn = DatabaseConnectionFactory.getConnection();
             PreparedStatement st = conn.prepareStatement("SELECT date_exchange_rate, abbreviation, currency_cost FROM app.currency_exchange_rate INNER JOIN app.currency USING(currency_id)WHERE abbreviation = '?';");
        ){
            st.setInt(1,currencyId);
            try (ResultSet rs = st.executeQuery();) {
                while (rs.next()) {
                     rateDTOList.add(new RateDTO(currencyId,rs.getBigDecimal("currency_cost"), rs.getDate("date_exchange_rate").toLocalDate().atStartOfDay(), true));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rateDTOList;
    }
}
