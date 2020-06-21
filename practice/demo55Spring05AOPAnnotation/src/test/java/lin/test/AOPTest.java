package lin.test;

import lin.service.IAccountService;
import lin.service.impl.AccountServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {
    ApplicationContext ac;
    IAccountService as;
    @Before
    public void init() {
        ac = new ClassPathXmlApplicationContext("bean.xml");
        as = (IAccountService)ac.getBean("accountService");

    }
    @Test
    public void saveTest() {
        as.saveAccount();
    }
    @Test
    public void updateTest() {
        as.updateAccount(1);
    }
    @Test
    public void allTest() {
        as.saveAccount();
        as.updateAccount(2);
        as.deleteAccount();
    }

    @Test
    public void transferOperation() {
        as.transfer("rich", "poor", 1000f);
    }
}
