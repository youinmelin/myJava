package lin.mapper;

import lin.pojo.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface IUserMapper extends Mapper<User>{
}
