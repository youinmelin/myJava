package lin.service.impl;

import lin.dao.IAccountDao;
import lin.dao.impl.IAccountDaoImpl;
import lin.domain.Account;
import lin.service.IAccountService;

import java.util.List;

public class AccountServiceImpl implements IAccountService {
    private IAccountDaoImpl accountDao;

    public AccountServiceImpl() {
        System.out.println("object has been built.");
    }

    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    public Account findAccountById(Integer id) {
        return accountDao.findAccountById(id);
    }

    public void saveAccount(Account account) {
        accountDao.saveAccount(account);

    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer id) {
        accountDao.deleteAccount(id);
    }

    public void saveAccount() {
//        System.out.println("method saveAccount has been implemented in service");
    }

    public void init() {
        System.out.println("object initialize");
    }
    public void destroy() {
        System.out.println("object destroyed");
    }

    public void setAccountDao(IAccountDaoImpl accountDao) {
        this.accountDao = accountDao;
    }

    public IAccountDaoImpl getAccountDao() {
        return accountDao;
    }
}
