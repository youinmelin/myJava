package lin.dao;

import lin.domain.Account;

import java.util.List;

public interface IAccountDao {
    // one to one
    List<Account> findAllAccount();
}
