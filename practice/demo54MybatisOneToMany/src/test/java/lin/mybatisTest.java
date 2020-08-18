package lin;

import lin.dao.IAccountDao;
import lin.dao.IUserDao;
import lin.domain.Account;
import lin.domain.User;
import lin.domain.queryVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class mybatisTest {

    private InputStream is;
    private SqlSession sqlSession;
    private IUserDao userDao;
    private IAccountDao accountDao;

    @Before
    public void init() throws Exception {
//        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        sqlSession = factory.openSession();
        userDao = sqlSession.getMapper(IUserDao.class);
        accountDao = sqlSession.getMapper(IAccountDao.class);

    }

    @After
    public void close() throws Exception {
        sqlSession.commit();
        sqlSession.close();
        is.close();
    }
    @Test
    public  void testFindAllUserAccount() {
        List<User> users = userDao.findAllUserAccount();
        for (User user: users ) {
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }
    @Test
    public void testFindAllAccount() {
        List<Account> accounts = accountDao.findAllAccount();
        for (Account account: accounts ) {
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }

    @Test
    public void testFindAll() {
        List<User> users = userDao.findAll();
        for (User user: users ) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindByUser() {
        User user = new User();
        user.setName("%n%");
        user.setTel("123");
        List<User> users = userDao.findByUser(user);
        for (User u: users ) {
            System.out.println(u);
        }
    }

    @Test
    public void testFindByVo() {
        queryVo vo = new queryVo();
        User user = new User();
        user.setName("youinme");
        vo.setUser(user);
        List<User> users = userDao.findByVo(vo);
        for (User u: users ) {
            System.out.println(u);
        }
    }

    @Test
    public void testFindAllUserRole() {
        List<User> users = userDao.findAllUserRole();
        for (User user : users) {
            System.out.println(user);
            System.out.println(user.getRoles());
        }
    }
}
