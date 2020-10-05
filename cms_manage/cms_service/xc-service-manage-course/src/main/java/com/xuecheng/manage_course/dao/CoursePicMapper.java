package com.xuecheng.manage_course.dao;

import com.xuecheng.framework.domain.course.CoursePic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CoursePicMapper {

    @Select("select * from course_pic where courseid = #{id}")
    public CoursePic findCoursePicById(String id);
}
