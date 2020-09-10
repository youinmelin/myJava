package lin.dao;

import lin.domain.Account;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Dao Interface of Account
 */
@Repository
public interface IAccountDao {

    @Select("select * from account where id = #{id}")
    public Account findAccountById(Integer id);

    @Select("select * from account")
    public List<Account> findAllAccount();

    @Select("insert into account (name, money, date) values(#{name}, #{money}, #{date})")
    public void saveAccount(Account account);


}
