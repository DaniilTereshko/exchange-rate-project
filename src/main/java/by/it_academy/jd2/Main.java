package by.it_academy.jd2;

import by.it_academy.jd2.dao.ds.DatabaseConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = DatabaseConnectionFactory.getConnection();
        if(connection != null){
            System.out.println("gdsgds");
        }
    }
}