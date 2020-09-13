package lin.service;

import lin.domain.Account;

import java.util.List;

public interface IAccountService {


    public Account findAccountById(Integer id);

    public List<Account> findAllAccount();

    public void saveAccount(Account account);


}
