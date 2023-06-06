package by.it_academy.jd2.dao.db.impl;

import by.it_academy.jd2.core.dto.CurrencyDTO;
import by.it_academy.jd2.dao.api.ICurrencyDAO;
import by.it_academy.jd2.dao.db.ds.DatabaseConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Currency;

public class CurrencyJDBCDAO implements ICurrencyDAO {

    @Override
    public CurrencyDTO getByType(String currencyType) {
        CurrencyDTO currencyDTO = new CurrencyDTO();
        try(Connection connection = DatabaseConnectionFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT cur_id, abbreviation FROM app.currency WHERE abbreviation = ? ORDER BY cur_id DESC LIMIT 1;");){
            statement.setString(1, currencyType);
            try(ResultSet resultSet = statement.executeQuery();) {
                if(resultSet.next()){
                    currencyDTO.setID(resultSet.getInt("cur_id"));
                    currencyDTO.setName(resultSet.getString("abbreviation"));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Ошибка выборки", e);
        }
        return currencyDTO;
    }

    @Override
    public CurrencyDTO save(CurrencyDTO item) {
        try(Connection connection = DatabaseConnectionFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO app.currency(cur_id, abbreviation) VALUES(?,?);");){
            statement.setInt(1, item.getID());
            statement.setString(2, item.getName());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Ошибка выборки", e);
        }
        return item;
    }
}
