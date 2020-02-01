package Impl;

import UserDao.UserDao;
import domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }

    public List<User> findAll() {
        SqlSession session = factory.openSession();
        List<User> users = session.selectList("UserDao.UserDao.findAll");
        session.close();
        return users;
    }

    public void saveUser(User user) {
        SqlSession session = factory.openSession();
        session.insert("UserDao.UserDao.saveUser",user);
        session.commit();
        session.close();
    }

    public void upData(User user) {
        SqlSession session = factory.openSession();
        session.insert("UserDao.UserDao.upData",user);
        session.commit();
        session.close();
    }

    public void deletUser(int id) {

    }

    public User selectUser(int id) {
        return null;
    }

    public List<User> selectByName(String name) {
        return null;
    }

    public int countAll() {
        return 0;
    }
}
