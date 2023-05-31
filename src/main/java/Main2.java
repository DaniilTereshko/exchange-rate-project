import by.it_academy.jd2.dao.db.ds.DatabaseConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class Main2 {
    public static void main(String[] args) throws SQLException {
        Connection connection = DatabaseConnectionFactory.getConnection();
        if(connection != null){
            System.out.println("a");
        }
    }
}
