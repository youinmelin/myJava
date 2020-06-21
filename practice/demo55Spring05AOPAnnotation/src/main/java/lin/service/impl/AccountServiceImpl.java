package lin.service.impl;

import lin.service.IAccountService;
import lin.dao.impl.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    AccountDao accountDao;

    public void saveAccount() {
//        int i = 1/0;
        System.out.println("save...");
    }

    public void updateAccount(int i) {
        System.out.println("update..." + i);

    }

    public int deleteAccount() {
        System.out.println("deleting...");
        return 0;
    }

    public void transfer(String fromAccount, String toAccount, Float money) {
        accountDao.updateAccount(fromAccount, money*-1f);
        int i = 1/0;
        accountDao.updateAccount(toAccount, money);
    }
}
