package by.it_academy.jd2.dao.db.ds;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnectionFactory {
    private static ComboPooledDataSource cpds;
    static {
        cpds = new ComboPooledDataSource();
        try {
            cpds.setDriverClass( "org.postgresql.Driver" ); //loads the jdbc driver
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
        cpds.setJdbcUrl( "jdbc:postgresql://ec2-3-125-38-63.eu-central-1.compute.amazonaws.com:5432/courses" );
        cpds.setUser("nbrb");
        cpds.setPassword("course2023");
        cpds.setMaxPoolSize(10);
    }

    private DatabaseConnectionFactory() {
    }

    public static Connection getConnection() throws SQLException {
        return cpds.getConnection();
    }

    private static void closeConnection(Connection c) throws SQLException {
        if (c != null && !c.isClosed()) {
            c.close();
        }
    }
}
