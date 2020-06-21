package lin.dao.impl;

import lin.dao.IAccountDao;
import org.springframework.stereotype.Repository;

@Repository("accountDao")
public class AccountDao implements IAccountDao{
    public void updateAccount(String name, Float money) {
        System.out.println("transfer: "+ name +" " + money + " $.");
    }

    public void transferSucceed() {
        System.out.println("transfer succeed");
    }

    public void transferFailed() {
        System.out.println("transfer failed.");

    }
}
