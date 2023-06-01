package by.it_academy.jd2.dao.db.impl;

import by.it_academy.jd2.dao.api.ICurrencyDAO;
import by.it_academy.jd2.dao.db.ds.DatabaseConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CurrencyJDBCDAO implements ICurrencyDAO {

    @Override
    public Integer getIdByType(String currencyType) {
        Integer cur_id = null;
        try(Connection connection = DatabaseConnectionFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT cur_id FROM app.currency WHERE abbreviation = ? ORDER BY cur_id DESC LIMIT 1;");){
            statement.setString(1, currencyType);
            try(ResultSet resultSet = statement.executeQuery();) {
                if(resultSet.next()){
                    cur_id = resultSet.getInt("cur_id");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Ошибка выборки", e);
        }
        return cur_id;
    }
}
