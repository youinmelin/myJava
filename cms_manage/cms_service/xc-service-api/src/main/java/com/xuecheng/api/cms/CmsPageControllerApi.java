package com.xuecheng.api.cms;

import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.model.response.QueryResponseResult;

import javax.management.Query;

public interface CmsPageControllerApi {
    // search pages
    public QueryResponseResult findList(Integer page, Integer size, QueryPageRequest queryPageRequest);
}
