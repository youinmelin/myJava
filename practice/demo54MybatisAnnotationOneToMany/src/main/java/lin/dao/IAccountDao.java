package lin.dao;

import lin.domain.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface IAccountDao {
    @Select("select * from account")
    @Results(
            id = "accountUserMapper", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "uid", column = "uid"),
            @Result(property = "money", column = "money"),
            @Result(property = "user", column = "uid", one = @One(select="lin.dao.IUserDao.findUserById",fetchType= FetchType.EAGER))
    })
    List<Account> findAllAcountWithUser();

    @Select("select * from account where uid = #{uid}")
    List<Account> findAccountByUid(Integer uid);
}
