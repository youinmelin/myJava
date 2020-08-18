package lin.dao.impl;

import lin.dao.IAccountDao;
import lin.domain.Account;

import java.util.ArrayList;
import java.util.List;

public class IAccountDaoImpl implements IAccountDao {
    public List<Account> findAllAccount() {
        Account ac1 = new Account(3,"name", (float) 999.99);
        List<Account> accounts = new ArrayList<Account>();
        accounts.add(ac1);
        return accounts;
    }

    public Account findAccountById(Integer id) {
        return null;
    }

    public void saveAccount(Account account) {

    }

    public void updateAccount(Account account) {

    }

    public void deleteAccount(Integer id) {

    }
}
