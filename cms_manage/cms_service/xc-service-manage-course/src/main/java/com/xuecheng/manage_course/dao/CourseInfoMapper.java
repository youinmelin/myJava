package com.xuecheng.manage_course.dao;

import com.xuecheng.framework.domain.course.CourseBase;
import com.xuecheng.framework.domain.course.CoursePic;
import com.xuecheng.framework.domain.course.ext.CourseInfo;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface CourseInfoMapper {

//    @Select("SELECT base.id cid, base.name cname, cpic.pic pic FROM course_base base LEFT JOIN course_pic cpic ON base.id = cpic.courseid")
//    @Select("select id,name,pic from course_base")
//    @Results(id = "findAllCourseInfo" , value = {
//            @Result(id = true, property = "id", column = "id"),
//            @Result(property = "name" , column = "name"),
//            @Result(property = "pic", column = "courseid",
//                    one = @One(select = "com.xuecheng.manage_course.dao.CoursePicMapper.findCoursePicById"))
//    })
//    @Select("select id, name, pic from course_base left join course_pic on course_base.id = course_pic.courseid")
//    List<CourseBase> findAllCourseInfo ();

    @Select("select id, name, pic from course_base left join course_pic on course_base.id = course_pic.courseid")
    List<CourseInfo> findAllCourseInfoWithPic ();
}
