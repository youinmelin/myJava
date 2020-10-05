package com.xuecheng.api.course;

import com.xuecheng.framework.domain.course.Teachplan;
import com.xuecheng.framework.domain.course.ext.CourseInfo;
import com.xuecheng.framework.domain.course.ext.TeachplanNode;
import com.xuecheng.framework.domain.course.request.CourseListRequest;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/*
课程管理接口
 */
@Api(value = "课程管理接口", description = "课程管理接口, 提供课程的增删改查")
public interface CourseControllerApi {

    @ApiOperation("查询课程计划")
    public TeachplanNode findTeachplanList (String courseId);

    @ApiOperation("添加课程计划")
    ResponseResult addTeachplan(Teachplan teachplan);

    @ApiOperation("查询所有课程包括图片信息")
    QueryResponseResult findAllCourseWithPic(int page, int size, CourseListRequest courseListRequest);
}
