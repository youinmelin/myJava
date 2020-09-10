package lin.service.impl;

import lin.dao.IAccountDao;
import lin.domain.Account;
import lin.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {

//    final IAccountDao accountDao;
//    @Autowired
//    public AccountServiceImpl(IAccountDao accountDao) {
//        this.accountDao = accountDao;
//    }
    @Autowired
    IAccountDao accountDao;

    public Account findAccountById(Integer id) {
        Account account = accountDao.findAccountById(1);
        return account;
    }

    public List<Account> findAllAccount() {
        System.out.println("BLL: find all account");
        System.out.println("accountDao: " + accountDao);
        List<Account> list = accountDao.findAllAccount();
        return list;
    }

    public void saveAccount(Account account) {
        System.out.println("BLL: save account");
        accountDao.saveAccount(account);
    }
}
