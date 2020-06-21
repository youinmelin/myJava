package lin.factory;

import lin.service.IAccountService;
import lin.service.impl.AccountServiceImpl;

public class StaticFactory {
    public static IAccountService getAccountService() {
        return new AccountServiceImpl();
    }
}
