package lin;

import lin.domain.Account;
import lin.service.IAccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJdbcTemplate {

    ApplicationContext ac;
    IAccountService as;

    @Before
    public void init() {
        ac = new ClassPathXmlApplicationContext("bean.xml");
        as = ac.getBean("accountService", IAccountService.class);

    }
    @Test
    public void testFindAccountById() {
        as.findAccountById(1);
    }

    @Test
    public void testTransfer() {
        as.transfer("aaa","ccc",200f);
    }
}
