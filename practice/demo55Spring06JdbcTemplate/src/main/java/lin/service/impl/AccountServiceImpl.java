package lin.service.impl;

import lin.dao.impl.AccountDaoImplDaoSupport;
import lin.domain.Account;
import lin.service.IAccountService;

import java.util.List;

public class AccountServiceImpl implements IAccountService {

    private AccountDaoImplDaoSupport accountDaoImplDaoSupport;

    public void setAccountDaoImplDaoSupport(AccountDaoImplDaoSupport accountDaoImplDaoSupport) {
        this.accountDaoImplDaoSupport = accountDaoImplDaoSupport;
    }

    @Override
    public void findAccountById(Integer id) {
        Account account = accountDaoImplDaoSupport.findAccountById(id);
        if (account == null) {
            System.out.println("find nothing.");
        }else {
            System.out.println("Find By Id: " + account);
        }
    }

    @Override
    public void findAccountByName(String name) {
        List<Account> accounts = accountDaoImplDaoSupport.findAccountByName(name);
        for (Account a :
                accounts) {
            System.out.println(a);
        }

    }

    @Override
    public void updateAccount(Account account) {
        accountDaoImplDaoSupport.updateAccount(account);

    }
}
