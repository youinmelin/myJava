package lin.test;

import lin.dao.IAccountDao;
import lin.domain.Account;
import lin.service.IAccountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.InputStream;
import java.util.List;

public class SpringTest {

    InputStream is ;
    SqlSessionFactory factory ;
    SqlSession sqlSession ;
    IAccountDao accountDao ;
    @Before
    public void setUp() throws Exception {
         is = Resources.getResourceAsStream("SqlMapConfig.xml");
         factory = new SqlSessionFactoryBuilder().build(is);
         sqlSession = factory.openSession();
         accountDao = sqlSession.getMapper(IAccountDao.class);
    }

    @After
    public void tearDown() throws Exception {
        sqlSession.close();
        is.close();
    }

    @Test
    public void testFindAllAccount() throws Exception {
        System.out.println(accountDao.findAllAccount());
    }

    @Test
    public void testFindAccountById() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService asBean = ac.getBean("accountService", IAccountService.class);
        System.out.println(asBean);
        Account accountById = asBean.findAccountById(2);
        System.out.println("findAccountById: " + accountById);
        List<Account> allAccount = asBean.findAllAccount();
        System.out.println("AllAccount: " + allAccount);
    }
}
