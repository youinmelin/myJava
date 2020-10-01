package com.xuecheng.manage_cms.service;

import com.xuecheng.framework.domain.cms.CmsTemplate;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.QueryResult;
import com.xuecheng.manage_cms.dao.CmsTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CmsTemplateService {

    @Autowired
    CmsTemplateRepository cmsTemplateRepository;

    public QueryResponseResult queryAllCmsTemplate() {
        List<CmsTemplate> cmsTemplates = cmsTemplateRepository.findAll();
        QueryResult queryResult = new QueryResult();
        queryResult.setList(cmsTemplates);
        queryResult.setTotal(cmsTemplates.size());
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;
    }

    public CmsTemplate queryCmsTemplateById(String id) {
        Optional<CmsTemplate> byId = cmsTemplateRepository.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        }
        return null;
    }
}
