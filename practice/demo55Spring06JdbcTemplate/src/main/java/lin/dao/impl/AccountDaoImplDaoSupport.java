package lin.dao.impl;

import lin.dao.IAccountDao;
import lin.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class AccountDaoImplDaoSupport extends JdbcDaoSupport implements IAccountDao {
/*
 继承了JdbcDaoSupport 就不用自己建立JdbcTemplate对象了，只需在xml文件中注入JdbcTemplate
 直接使用getJdbcTemplate()
 */
//    private JdbcTemplate jt;
//
//    public void setJt(JdbcTemplate jt) {
//        this.jt = jt;
//    }

    @Override
    public Account findAccountById(Integer id) {
        List<Account> accounts = getJdbcTemplate().query(
                "select * from account where id = ?",
                new BeanPropertyRowMapper<Account>(Account.class),
                id);
        return accounts.isEmpty()?null:accounts.get(0);

    }

    @Override
    public List<Account> findAccountByName(String name) {
        List<Account> accounts = getJdbcTemplate().query("select * from account where name = ?",
                new BeanPropertyRowMapper<Account>(Account.class),
                name);
        return accounts.isEmpty()?null:accounts;
    }

    @Override
    public void updateAccount(Account account) {
        String name = account.getName();
        Float money = account.getMoney();
        Integer id = account.getId();
        getJdbcTemplate().update("update account set name = ?, money = ? where id = ?", name, money, id);

    }
}
