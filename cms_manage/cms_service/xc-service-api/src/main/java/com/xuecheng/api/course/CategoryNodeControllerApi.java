package com.xuecheng.api.course;

import com.xuecheng.framework.domain.course.ext.CategoryNode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "课程管理接口", description = "课程管理接口, 提供课程的增删改查")
public interface CategoryNodeControllerApi {

    @ApiOperation("查询课程分类树形结构")
    CategoryNode findAllCategoryNode();
}
