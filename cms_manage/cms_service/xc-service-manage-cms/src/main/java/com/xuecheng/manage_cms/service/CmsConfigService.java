package com.xuecheng.manage_cms.service;

import com.xuecheng.framework.domain.cms.CmsConfig;
import com.xuecheng.manage_cms.dao.CmsConfigRepoistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class CmsConfigService {

    @Autowired
    CmsConfigRepoistory cmsConfigRepoistory;
    @Autowired
    RestTemplate restTemplate;

    public CmsConfig findCmsConfigById(String id) {
        Optional<CmsConfig> byId = cmsConfigRepoistory.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        }
        return  null;
    }
}
