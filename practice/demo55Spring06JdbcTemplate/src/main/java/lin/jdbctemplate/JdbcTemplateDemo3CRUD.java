package lin.jdbctemplate;

import lin.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * basic use of JdbcTemplate
 */
public class JdbcTemplateDemo3CRUD {
    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jt = (JdbcTemplate)ac.getBean("JdbcTemplate");

        jt.update("INSERT INTO account (name,money) VALUES (?,?)", "eee",1020f);

        jt.update("UPDATE account SET money=? WHERE id=?", 2200f,5);

//        jt.update("DELETE FROM account WHERE name=?", "eee");


        List<Account> accounts = jt.query("select * from account where money > ?",new AccountRowMapper(),1000f );
        for (Account a :
                accounts) {
            System.out.println(a);
        }
    }
}

/*
定义Account的封装策略
 */
class AccountRowMapper implements RowMapper<Account> {
    /**
     * Implementations must implement this method to map each row of data
     * in the ResultSet. This method should not call {@code next()} on
     * the ResultSet; it is only supposed to map values of the current row.
     *
     * @param rs     the ResultSet to map (pre-initialized for the current row)
     * @param rowNum the number of the current row
     * @return the result object for the current row (may be {@code null})
     * @throws SQLException if a SQLException is encountered getting
     *                      column values (that is, there's no need to catch SQLException)
     */
    @Nullable
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account account = new Account();
        account.setId(rs.getInt("id"));
        account.setName(rs.getString("name"));
        account.setMoney(rs.getFloat("money"));
        return account;
    }
    /**
     * 把结果集中的数据封装到Account中，然后由spring把每个Account加到集合中
     */
}
