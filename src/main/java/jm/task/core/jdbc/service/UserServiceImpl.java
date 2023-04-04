package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    private static final UserDaoJDBCImpl daoJDBC = new UserDaoJDBCImpl();
    private static List<User> userList = new ArrayList<>();

    public void createUsersTable() {
        daoJDBC.createUsersTable();
    }

    public void dropUsersTable() {
        daoJDBC.dropUsersTable();
        userList.clear();
    }

    public void saveUser(String name, String lastName, byte age) {
        daoJDBC.saveUser(name, lastName, age);
        userList.add(new User(name, lastName, age));
    }

    public void removeUserById(long id) {
        daoJDBC.removeUserById(id);
        userList.remove(id);
    }

    public List<User> getAllUsers() {
        userList = daoJDBC.getAllUsers();
        return userList;
    }

    public void cleanUsersTable() {
        daoJDBC.cleanUsersTable();
        userList.clear();
    }
}
