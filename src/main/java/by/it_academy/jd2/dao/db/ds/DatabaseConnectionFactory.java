package by.it_academy.jd2.dao.db.ds;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DatabaseConnectionFactory {
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "R2-D2-F1-L1";
    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;
    static {
        try(InputStream input = new FileInputStream("src/main/resources/database.properties")) {
            Properties properties = new Properties();
            properties.load(input);

            config.setDataSourceClassName("org.postgresql.ds.PGSimpleDataSource");
            config.addDataSourceProperty("serverName", properties.getProperty("serverName"));
            config.addDataSourceProperty("portNumber", properties.getProperty("portNumber"));
            config.addDataSourceProperty("databaseName", properties.getProperty("databaseName"));
            config.addDataSourceProperty("user", properties.getProperty("username"));
            config.addDataSourceProperty("password", properties.getProperty("password"));

            ds = new HikariDataSource(config);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
