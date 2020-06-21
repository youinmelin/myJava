package lin;

import lin.config.SpringConfiguration;
import lin.domain.Account;
import lin.service.IAccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DynamicTest;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class TestJdbcTemplate {

//    ApplicationContext ac;
    @Autowired
    IAccountService as;

//    @Before
//    public void init() {
//        ac = new ClassPathXmlApplicationContext("bean.xml");
//        as = ac.getBean("accountService", IAccountService.class);
//
//    }
    @Test
    public void testFindAccountById() {
        as.findAccountById(1);
    }

    @Test
    public void testTransfer() {
        as.transfer("aaa","ccc",200f);
    }
}
