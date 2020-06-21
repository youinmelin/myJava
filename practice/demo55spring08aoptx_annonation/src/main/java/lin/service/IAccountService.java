package lin.service;


import lin.domain.Account;

public interface IAccountService {

    void findAccountById(Integer id);

    void transfer(String sourceName,String targetName, Float money);

}
