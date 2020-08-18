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
    public void testFindAccountByName() {
        as.findAccountByName("eee");
    }
    @Test
    public void testUpdateAccount() {
        Account a = new Account();
        a.setId(2);
        a.setName("newAccount");
        a.setMoney(1999f);
        as.updateAccount(a);
    }
}
