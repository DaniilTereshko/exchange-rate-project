package by.it_academy.jd2.dao.db.impl;

import by.it_academy.jd2.core.dto.RateDTO;
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
        //сохраняем в БД
        return null;
    }
    @Override
    public List<RateDTO> get(RateRequestDTO rateRequestDTO) {
        return null;
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
                     rateDTOList.add(new RateDTO(currencyId,rs.getBigDecimal("currency_cost"), rs.getDate("date_exchange_rate"), true));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rateDTOList;
    }
}
