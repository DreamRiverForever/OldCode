package test;

import UserDao.UserDao;
import domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {

    private InputStream in;
    private SqlSession sqlSession;
    private UserDao userDao;

    @Before
    public void init() throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        sqlSession = factory.openSession();
        //动态代理
        userDao = sqlSession.getMapper(UserDao.class);
    }
    @After
    public void destroy() throws Exception{
        in.close();
        sqlSession.close();
    }

    @Test
    public  void testFindAll() throws Exception{
        List<User> userList = userDao.findAll();
        for (User user:userList
             ) {
            System.out.println(user);
        }
        sqlSession.close();
        in.close();
    }

    @Test
    public void testSave() throws Exception{
        User user = new User();
        user.setName("何佳楠");
        user.setAddress("南通");
        user.setBirthday(new Date());
        user.setSex("男");
        System.out.println(user);
        userDao.saveUser(user);
        sqlSession.commit();
        System.out.println(user );
    }

    @Test
    public void testUpData() throws Exception{
        User user = new User();
        user.setName("胡世豪");
        user.setAddress("信阳");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setId(41);
        userDao.upData(user);
        sqlSession.commit();

    }

    @Test
    public void testdeletUser() throws Exception{

        userDao.deletUser(42);
        sqlSession.commit();
    }

    @Test
    public void testselectUser() throws Exception{

        User user = userDao.selectUser(49);
        System.out.println(user);
    }

    @Test
    public void selectByName() throws Exception{

        List<User> list = userDao.selectByName("%邓%");
        for (User user:list
        ) {
            System.out.println(user);
        }
    }

    @Test
    public void countAll() throws Exception{

        System.out.println(userDao.countAll());
    }
}
