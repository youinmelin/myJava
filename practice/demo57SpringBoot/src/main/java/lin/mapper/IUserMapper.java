package lin.mapper;

import lin.pojo.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.spring.annotation.MapperScan;

@Repository
public interface IUserMapper extends Mapper<User> {

}
