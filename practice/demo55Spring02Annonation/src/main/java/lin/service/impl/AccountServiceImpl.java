package lin.service.impl;

import lin.dao.IAccountDao;
import lin.domain.Account;
import lin.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * XML: <bean id="accountService" class="lin.service.impl.AccountServiceImpl"
 *          init-method="init" destroy-method="destroy"></ bean>
 *          <property name="" value=""/ref=""/>
 * Annonation:
 * build object: @Component
 * inject
 * change scope
 * life time
 */
@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountDao accountDao;
//    private Account account1;
    public AccountServiceImpl() {
        System.out.println("object has been built.");
    }
    public void saveAccount() {
        System.out.println("accountDao: " + accountDao);
        accountDao.useDao();
        System.out.println("method saveAccount has been implemented in service");
//        System.out.println("account1: " + account1);
    }
    public void init() {
        System.out.println("object initialize");
    }
    public void destroy() {
        System.out.println("object destroyed");
    }
}
