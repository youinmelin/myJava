package lin.test;

import lin.dao.IAccountDao;
import lin.dao.IUserDao;
import lin.domain.Account;
import lin.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
    private IUserDao userDao;
    private IAccountDao accountDao;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession();
        userDao = sqlSession.getMapper(IUserDao.class);
        accountDao = sqlSession.getMapper(IAccountDao.class);
    }

    @After
    public void destory() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    @Test
    public void testFindAllUser() {
        List<User> users = userDao.findAllUser();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindUserByName() {
        User user = new User();
        user.setUsername("%王%");
        List<User> users = userDao.findUserByName(user.getUsername());
        for (User u: users) {
            System.out.println(u);
        }
    }

    // one to one with annotation
    @Test
    public void testFindAllAccountWithUser() {
        List<Account> accounts = accountDao.findAllAcountWithUser();
        for (Account account : accounts) {
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }

    // one to many with annotation
    @Test
    public void testFinaAllUserWithAccount() {
        List<User> users = userDao.findAllUserWithAccount();
        for (User u : users) {
            System.out.println(u);
            System.out.println(u.getAccounts());
        }
    }
}
