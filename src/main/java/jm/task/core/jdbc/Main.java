package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Vasa", "Pupkin", (byte) 18);
        userService.saveUser("Petr", "Ivanov", (byte) 22);
        userService.saveUser("John", "Smith", (byte) 32);
        List<User> userList = userService.getAllUsers();
        userList.forEach(System.out::println);
        userService.cleanUsersTable();
        userService.dropUsersTable();

    }
}
