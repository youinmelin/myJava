package com.lin.mapper;

import com.lin.domain.Teachplan;
import com.lin.domain.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface UserMapper extends Mapper<User>{


}
