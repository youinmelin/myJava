package lin.dao;

public interface IAccountDao {

    void updateAccount(String name, Float money);

    void transferSucceed();

    void transferFailed();

}
