package com.xuecheng.api.cms;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.domain.cms.response.CmsPageResult;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import javax.management.Query;
@Api(value="cms页面管理接口",description="cms页面管理接口，提供页面的增、删、改、查")
public interface CmsPageControllerApi {
    // search pages
    @ApiOperation("分页查询页面列表")
    @ApiImplicitParams({
           @ApiImplicitParam(name="page",value="页码",required=true,paramType="path",dataType="int"),
           @ApiImplicitParam(name="size",value="每页记录数",required=true,paramType="path",dataType="int") })
    public QueryResponseResult findList(Integer page, Integer size, QueryPageRequest queryPageRequest);

    public QueryResponseResult findListByExample(Integer page, Integer size, QueryPageRequest queryPageRequest);

    // add a new page data
    @ApiOperation("新增页面")
    public CmsPageResult addCmsPage(CmsPage cmsPage);

    // query page data by pageId
    @ApiOperation("根据页面id查询页面信息")
    public CmsPage findCmsPageById(String id);

    // modify page data
    @ApiOperation("修改页面信息")
    public CmsPageResult modifyCmsPage(String id, CmsPage cmsPage);


    // delete page data
    @ApiOperation("删除页面信息")
    public ResponseResult delCmsPage(String id);

    // 页面发布
    @ApiOperation("页面发布")
    ResponseResult post(String pageId);

}
