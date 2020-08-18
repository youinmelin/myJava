package lin.dao;

import lin.domain.Account;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IAccountDao {

    @Select("select * from account")
    List<Account> findAllAccount();

    @Select("select * from account where id = #{id}")
    Account findAccountById(Integer id);

    @Insert("insert into account(name,money) values(#{account.getName()},#{account.getMoney)}")
    void saveAccount(Account account);

    @Update("update acount set name = #{account.getName()}, money=#{account.getMoney()} whewe id = #{account.getId()}")
    void updateAccount(Account account);

    @Delete("delete from account where id = #{acount.getId()")
    void deleteAccount(Integer id);

}
