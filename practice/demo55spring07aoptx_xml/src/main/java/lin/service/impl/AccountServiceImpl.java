package lin.service.impl;

import lin.dao.impl.AccountDaoImpl;
import lin.domain.Account;
import lin.service.IAccountService;

import java.util.List;

public class AccountServiceImpl implements IAccountService {

    private AccountDaoImpl accountDaoImpl;

    public void setAccountDaoImpl(AccountDaoImpl accountDaoImpl) {
        this.accountDaoImpl = accountDaoImpl;
    }

    public void findAccountById(Integer id) {
        Account account = accountDaoImpl.findAccountById(id);
        if (account == null) {
            System.out.println("find nothing.");
        }else {
            System.out.println("Find By Id: " + account);
        }
    }

    public void transfer(String sourceName, String targetName, Float money) {
        Account sourceAccount = accountDaoImpl.findAccountByName(sourceName);
        Account targetAccount = accountDaoImpl.findAccountByName(targetName);
        sourceAccount.setMoney(sourceAccount.getMoney()-money);
        targetAccount.setMoney(targetAccount.getMoney()+money);
        accountDaoImpl.updateAccount(sourceAccount);
//        int i = 1/0;
        accountDaoImpl.updateAccount(targetAccount);

    }

}
