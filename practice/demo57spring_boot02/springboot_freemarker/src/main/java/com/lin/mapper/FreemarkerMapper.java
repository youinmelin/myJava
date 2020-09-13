package com.lin.mapper;

import com.lin.pojo.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface FreemarkerMapper extends Mapper<User> {
}
