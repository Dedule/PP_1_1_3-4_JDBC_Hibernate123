package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    public static Configuration getConfiguration() {
        return new Configuration().addAnnotatedClass(User.class);
    }
}
