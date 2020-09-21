package com.xuecheng.api.cms;

import com.xuecheng.framework.model.response.QueryResponseResult;
import io.swagger.annotations.Api;

@Api(value="cms模板管理接口")
public interface CmsTemplateControllerApi {

    public QueryResponseResult queryAllCmsTemplate() ;

}
