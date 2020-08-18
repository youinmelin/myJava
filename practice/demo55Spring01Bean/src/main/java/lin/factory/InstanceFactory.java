package lin.factory;

import lin.service.IAccountService;
import lin.service.impl.AccountServiceImpl;

public class InstanceFactory {
    public IAccountService getAccountService() {
        return new AccountServiceImpl();
    }
}
