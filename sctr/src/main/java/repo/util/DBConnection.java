package repo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String DB_URI = "jdbc:mysql://localhost:/my_programm";
    private static final String DB_USER = "root";
    private static final String DB_PASS = " ";


    public static Connection getConnection() {
        Connection con;
        try {
            con = DriverManager.getConnection(DB_URI, DB_USER, DB_PASS);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return con;
    }
}
