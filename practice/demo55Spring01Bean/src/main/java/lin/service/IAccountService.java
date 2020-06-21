package lin.service;

import lin.domain.Account;

import java.util.List;

//账户的业务层接口
public interface IAccountService {
    void saveAccount();

    List<Account> findAllAccount();

    Account findAccountById(Integer id);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer id);
}
