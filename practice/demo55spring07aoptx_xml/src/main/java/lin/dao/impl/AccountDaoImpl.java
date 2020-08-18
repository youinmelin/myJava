package lin.dao.impl;

import lin.dao.IAccountDao;
import lin.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao {

    private JdbcTemplate jt;

    public void setJt(JdbcTemplate jt) {
        this.jt = jt;
    }

    @Override
    public Account findAccountById(Integer id) {
        List<Account> accounts = getJdbcTemplate().query(
                "select * from account where id = ?",
                new BeanPropertyRowMapper<Account>(Account.class),
                id);
        return accounts.isEmpty()?null:accounts.get(0);

    }

    @Override
    public Account findAccountByName(String name) {
        List<Account> accounts = getJdbcTemplate().query("select * from account where name = ?",
                new BeanPropertyRowMapper<Account>(Account.class),
                name);
        return accounts.isEmpty()?null:accounts.get(0);
    }

    @Override
    public void updateAccount(Account account) {
        String name = account.getName();
        Float money = account.getMoney();
        Integer id = account.getId();
        getJdbcTemplate().update("update account set name = ?, money = ? where id = ?", name, money, id);

    }
}
