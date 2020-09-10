package lin;

import lin.dao.IAccountDao;
import lin.domain.Account;
import lin.service.IAccountService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class testSSM {


    @Autowired
    public IAccountService accountService;

//    final IAccountService accountService;
//    @Autowired
//    public testSSM(IAccountService accountService) {
//        this.accountService = accountService;
//    }

    @Test
    public void testFindAllAccount() {
        System.out.println("USL:test find all account.");
        System.out.println("accountService: " + this.accountService);
        List<Account> accounts = this.accountService.findAllAccount();
        for (Account a :
                accounts) {
            System.out.println(a);
        }
    }
}
