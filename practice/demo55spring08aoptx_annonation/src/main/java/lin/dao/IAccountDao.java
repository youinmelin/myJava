package lin.dao;

import lin.domain.Account;

import java.util.List;

public interface IAccountDao {
    Account findAccountById(Integer id);

    Account findAccountByName(String name);

    void updateAccount(Account account);


}
