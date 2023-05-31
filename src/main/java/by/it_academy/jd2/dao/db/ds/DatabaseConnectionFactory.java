package by.it_academy.jd2.dao.db.ds;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DatabaseConnectionFactory {
    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;
    static {


        config.setDataSourceClassName("org.postgresql.ds.PGSimpleDataSource");
        config.addDataSourceProperty("serverName", "ec2-3-125-38-63.eu-central-1.compute.amazonaws.com");
        config.addDataSourceProperty("portNumber", "5432");
        config.addDataSourceProperty("databaseName", "courses");
        config.addDataSourceProperty("user", "nbrb");
        config.addDataSourceProperty("password", "course2023");

        ds = new HikariDataSource(config);

    }

    private DatabaseConnectionFactory() {
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    private static void closeConnection(Connection c) throws SQLException {
        if (c != null && !c.isClosed()) {
            c.close();
        }
    }
}
