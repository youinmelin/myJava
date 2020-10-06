package com.xuecheng.manage_course.controller;

import com.xuecheng.api.course.CourseControllerApi;
import com.xuecheng.framework.domain.course.CourseBase;
import com.xuecheng.framework.domain.course.Teachplan;
import com.xuecheng.framework.domain.course.ext.TeachplanNode;
import com.xuecheng.framework.domain.course.request.CourseListRequest;
import com.xuecheng.framework.domain.course.response.AddCourseResult;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.manage_course.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController implements CourseControllerApi{

    @Autowired
    CourseService courseService;

    @Override
    @GetMapping("/teachplan/list/{courseId}")
    public TeachplanNode findTeachplanList(@PathVariable("courseId") String courseId) {
        return courseService.findTeachplanList(courseId);
    }

    @Override
    @PostMapping("/teachplan/add")
    public ResponseResult addTeachplan(@RequestBody Teachplan teachplan) {
        return courseService.addTeachplan(teachplan);
    }

    @Override
    @GetMapping("/coursebase/list/{page}/{size}")
    public QueryResponseResult findAllCourseWithPic(@PathVariable("page") int page,@PathVariable("page")  int size, CourseListRequest courseListRequest) {
        return courseService.fingAllCourseWithPic(page,size,courseListRequest);
    }

    @Override
    @GetMapping("/coursebase/byid/{courseid}")
    public CourseBase findCourseBaseById(@PathVariable("courseid") String courseId) {
        return courseService.findCourseBaseById(courseId);
    }

    @Override
    @PutMapping("/coursebase/update/{courseid}")
    public ResponseResult updateCourseBase(@PathVariable("courseid") String courseId,@RequestBody CourseBase courseBase) {
        return courseService.updateCourseBase(courseId, courseBase
        );
    }

    @Override
    @PostMapping("/coursebase/add")
    public AddCourseResult addCourseBase(@RequestBody CourseBase courseBase) {
        return courseService.addCourseBase(courseBase);
    }

}

