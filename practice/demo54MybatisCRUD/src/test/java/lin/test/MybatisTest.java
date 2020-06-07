package lin.test;

import lin.dao.IUserDao;
import lin.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before
    public void init() throws Exception {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession();
        Class<IUserDao> iUserDaoClass = IUserDao.class;
        userDao = sqlSession.getMapper(iUserDaoClass);
    }

    @After
    public void destory() throws  Exception {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    @Test
    public void testFindAll() throws Exception{
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testSave() throws Exception {
        User user = new User();
        user.setBrithday("2011-12-04");
        user.setSex("M");
        user.setUsername("Nasa");
        System.out.println(user);
        userDao.saveUser(user);
        System.out.println("after:" + user);
    }

    @Test
    public void testUpdate() throws Exception {
        User user = new User(41, "zhang san", "F", "1990-5-5");
        userDao.updateUser(user);
    }

    @Test
    public void testDel() throws Exception {
        userDao.delUser(42);
    }

    @Test
    public void testFindById() throws Exception {
        User user = userDao.findById(50);
        System.out.println(user);
    }

    @Test
    public void testFindByName() throws Exception {
        List<User> users = userDao.findByName("%n%");
        for (User user : users) {
            System.out.println(user);
        }
    }
}
