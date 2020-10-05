package com.xuecheng.manage_course.dao;

import com.xuecheng.framework.domain.course.CourseBase;
import com.xuecheng.framework.domain.course.CoursePic;
import com.xuecheng.framework.domain.course.ext.CategoryNode;
import com.xuecheng.framework.domain.course.ext.CourseInfo;
import com.xuecheng.framework.domain.course.ext.TeachplanNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

/**
 * @author Administrator
 * @version 1.0
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestDao {
    @Autowired
    CourseBaseRepository courseBaseRepository;
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    TeachplanMapper teachplanMapper;
    @Autowired
    CourseInfoMapper courseInfoMapper;
    @Autowired
    CoursePicMapper coursePicMapper;
    @Autowired
    CategoryNodeMapper categoryNodeMapper;


    @Test
    public void testCourseBaseRepository(){
        Optional<CourseBase> optional = courseBaseRepository.findById("402885816240d276016240f7e5000002");
        if(optional.isPresent()){
            CourseBase courseBase = optional.get();
            System.out.println(courseBase);
        }
    }

    @Test
    public void testCourseMapper(){
        CourseBase courseBase = courseMapper.findCourseBaseById("402885816240d276016240f7e5000002");
        System.out.println(courseBase);
    }

    @Test
    public void testTeachplanList() {
        String courseId = "4028e581617f945f01617f9dabc40000";
        TeachplanNode node = teachplanMapper.selectTeachplanList(courseId);
        System.out.println(node);
    }


    @Test
    public void testFindAllCourseBase() {
        List<CourseBase> courseBases = courseMapper.findAllCourseBase();
        System.out.println("---------------" + courseBases);
    }

    @Test
    public void testFindAllCourseWithPic() {
        List<CourseBase> courseInfos = courseInfoMapper.findAllCourseInfo();
        System.out.println("------------" + courseInfos);
    }

    @Test
    public void testFindCoursePicById() {
        CoursePic coursePicById = coursePicMapper.findCoursePicById("4028e58161bcf7f40161bcf8b77c0000");
        System.out.println(coursePicById);
    }

    @Test
    public void testAllCategoryNode() {
        CategoryNode allCategoryNodes = categoryNodeMapper.findAllCategoryNode();
        System.out.println(allCategoryNodes);

    }
}
