package lin.dao.impl;

import lin.dao.IAccountDao;
import lin.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Account findAccountById(Integer id) {
        List<Account> accounts = jdbcTemplate.query(
                "select * from account where id = ?",
                new BeanPropertyRowMapper<Account>(Account.class),
                id);
        return accounts.isEmpty()?null:accounts.get(0);

    }

    @Override
    public Account findAccountByName(String name) {
        List<Account> accounts = jdbcTemplate.query("select * from account where name = ?",
                new BeanPropertyRowMapper<Account>(Account.class),
                name);
        return accounts.isEmpty()?null:accounts.get(0);
    }

    @Override
    public void updateAccount(Account account) {
        String name = account.getName();
        Float money = account.getMoney();
        Integer id = account.getId();
        jdbcTemplate.update("update account set name = ?, money = ? where id = ?", name, money, id);

    }
}
