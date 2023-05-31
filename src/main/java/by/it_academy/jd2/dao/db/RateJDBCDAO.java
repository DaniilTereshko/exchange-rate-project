package by.it_academy.jd2.dao.db;

import by.it_academy.jd2.core.dto.RateDTO;
import by.it_academy.jd2.dao.API.IRateDAO;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public BigDecimal getAverage(String curAbbreviation){
        //PreparedStatement preparedStatement = ("SELECT abbreviation, currency_cost FROM app.currency_exchange_rate INNER JOIN app.currency USING(currency_id) WHERE abbreviation = '?'");
        //preparedStatement.setString(curAbbreviation);
        //ResultSet resultSet = preparedStatement.executeQuery();

        return null;
    }
}
