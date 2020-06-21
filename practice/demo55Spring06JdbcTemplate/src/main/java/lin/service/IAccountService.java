package lin.service;


import lin.domain.Account;

public interface IAccountService {

    void findAccountById(Integer id);

    void findAccountByName(String name);

    void updateAccount(Account account);

}
