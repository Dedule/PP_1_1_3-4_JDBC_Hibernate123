package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/my_database";
    private static final String LOG = "root";
    private static final String PASS = "0000";

    public static Configuration getConfiguration() {
        return new Configuration().addAnnotatedClass(User.class);
    }
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL,LOG,PASS);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
