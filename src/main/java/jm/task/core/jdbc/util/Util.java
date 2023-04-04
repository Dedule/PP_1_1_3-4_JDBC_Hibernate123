package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String LOG = "root";
    private static final String PASS = "0000";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL,LOG,PASS);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
