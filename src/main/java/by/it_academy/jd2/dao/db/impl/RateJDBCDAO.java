package by.it_academy.jd2.dao.db.impl;

import by.it_academy.jd2.core.dto.RateDTO;
import by.it_academy.jd2.core.dto.RateRequestDTO;
import by.it_academy.jd2.dao.api.IRateDAO;
import by.it_academy.jd2.dao.db.ds.DatabaseConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RateJDBCDAO implements IRateDAO {
    @Override
    public List<RateDTO> get() {
        return null;
    }

    @Override
    public List<RateDTO> save(List<RateDTO> dtos) {
        try(Connection connection = DatabaseConnectionFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO app.currency_exchange_rate(currency_id, currency_cost, date_exchange_rate, is_weekend)" +
                    "VALUES(?, ?, ?, ?);");){
            for (RateDTO rateDTO:dtos){
                statement.setObject(1, rateDTO.getCurrencyID());
                statement.setBigDecimal(2, rateDTO.getCurrencyCost());
                statement.setDate(3, rateDTO.getDateExchangeRate());
                statement.setBoolean(4, rateDTO.isWeekend());
                statement.addBatch();
            }
            int i = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка вставки", e);
        }
        return dtos;
    }
    @Override
    public List<RateDTO> get(RateRequestDTO rateRequestDTO) {
        return null;
    }

    @Override
    public List<RateDTO> get(String currencyType) {
        return null;
    }
}
