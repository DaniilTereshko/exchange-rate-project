package by.it_academy.jd2.dao.ds;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;

public class DatabaseConnectionFactory {
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "R2-D2-F1-L1";
    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;
    static {
        config.setDataSourceClassName("org.postgresql.ds.PGSimpleDataSource");
        config.addDataSourceProperty("serverName", "localhost");
        config.addDataSourceProperty("portNumber", "5432");
        config.addDataSourceProperty("databaseName", "---");
        config.addDataSourceProperty("user", USERNAME);
        config.addDataSourceProperty("password", PASSWORD);
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
