package lin.ui;

import lin.dao.IAccountDao;
import lin.domain.Account;
import lin.service.IAccountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.InputStream;
import java.util.List;

public class Client {
    public static void main(String[] args) throws Exception{
        //1. get core container object
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2. build Bean object by id
        IAccountService as = (IAccountService)ac.getBean("accountService");
        IAccountService asSet = (IAccountService)ac.getBean("accountServiceSetInjection");
        IAccountService asOther = (IAccountService)ac.getBean("accountServiceImplOtherType");
        Account account1 = (Account)ac.getBean("accountSetInjection") ;
//        IAccountDao adao = ac.getBean("accountDao", IAccountDao.class);

        // use mybatis
        List<Account> accounts ;
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = factory.openSession();
        IAccountDao accountDao = sqlSession.getMapper(IAccountDao.class);
        System.out.println("findAllAccount:" + accountDao.findAllAccount());
        System.out.println("findAccountById:" + accountDao.findAccountById(2));

        System.out.println(asSet);
        System.out.println("account1: " + account1);
        as.saveAccount();
        asOther.saveAccount();
        ac.close();

    }
}
