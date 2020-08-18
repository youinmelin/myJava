package lin.service;

/**
 * 业务层接口
 */
public interface IAccountService {

    void saveAccount();

    void updateAccount(int i);

    int deleteAccount();

    void transfer (String fromAccount, String toAccount, Float money);

}
