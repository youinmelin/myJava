package com.lin.mapper;


import com.lin.pojo.Students;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
public interface StuMapper extends Mapper<Students> {

}
