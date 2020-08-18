package lin.service.impl;

import lin.service.IAccountService;

public class AccountServiceImpl implements IAccountService {
    public void saveAccount() {
        int i = 1/0;
        System.out.println("save...");
    }

    public void updateAccount(int i) {
        System.out.println("update..." + i);

    }

    public int deleteAccount() {
        System.out.println("deleting...");
        return 0;
    }
}
