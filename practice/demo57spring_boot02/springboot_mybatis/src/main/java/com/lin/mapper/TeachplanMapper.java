package com.lin.mapper;

import com.lin.domain.Teachplan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TeachplanMapper extends tk.mybatis.mapper.common.Mapper<Teachplan>{

    @Select("select * from teachplan where courseid = #{courseId}")
    List<Teachplan> findByCourseId (String courseId);
}
