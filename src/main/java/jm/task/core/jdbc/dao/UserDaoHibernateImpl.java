package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        try (SessionFactory sf = Util.getConfiguration().buildSessionFactory();
             Session s = sf.getCurrentSession()) {
            s.beginTransaction();
            s.createSQLQuery("CREATE TABLE IF NOT EXISTS user (\n" +
                    "  `id` BIGINT NOT NULL AUTO_INCREMENT,\n" +
                    "  `name` VARCHAR(45) NOT NULL,\n" +
                    "  `lastName` VARCHAR(45) NOT NULL,\n" +
                    "  `age` TINYINT(100) NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)").executeUpdate();
            s.getTransaction().commit();
        }
    }

    @Override
    public void dropUsersTable() {
        try (SessionFactory sf = Util.getConfiguration().buildSessionFactory();
             Session s = sf.getCurrentSession()) {
            s.beginTransaction();
            s.createSQLQuery("drop table if exists user").executeUpdate();
            s.getTransaction().commit();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try (SessionFactory sf = Util.getConfiguration().buildSessionFactory();
             Session s = sf.getCurrentSession()) {
            s.beginTransaction();
            s.save(new User(name, lastName, age));
            s.getTransaction().commit();
        }
    }

    @Override
    public void removeUserById(long id) {
        try (SessionFactory sf = Util.getConfiguration().buildSessionFactory();
             Session s = sf.getCurrentSession()) {
            s.beginTransaction();
            s.delete(s.get(User.class, id));
            s.getTransaction().commit();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = null;
        try (SessionFactory sf = Util.getConfiguration().buildSessionFactory();
             Session s = sf.getCurrentSession()) {
            s.beginTransaction();
            userList = s.createQuery("FROM User").getResultList();
            s.getTransaction().commit();
        }
        return userList;
    }

    @Override
    public void cleanUsersTable() {
        try (SessionFactory sf = Util.getConfiguration().buildSessionFactory();
             Session s = sf.getCurrentSession()) {
            s.beginTransaction();
            s.createQuery("delete from User").executeUpdate();
            s.getTransaction().commit();
        }
    }
}
