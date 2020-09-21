package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// extends MongoRepository<实体类，主键类型> 已经定义好了很多方法，类似于通用mapper
public interface CmsPageRepository extends MongoRepository<CmsPage, String>{

    /**
     * 同Spring Data JPA一样Spring Data mongodb也提供自定义方法的规则，如下：
     * 按照findByXXX，findByXXXAndYYY、countByXXXAndYYY等规则定义方法，实现查询操作。
     * @param pageName
     * @return
     */
    // 根据页面名称查询
    CmsPage findByPageName(String pageName);
    //根据页面名称和类型查询
    CmsPage findByPageNameAndPageType(String pageName,String pageType);
    //根据站点和页面类型查询记录数
    int countBySiteIdAndPageType(String siteId,String pageType);
    //根据站点和页面类型分页查询
    Page<CmsPage> findBySiteIdAndPageType(String siteId, String pageType, Pageable pageable);
    // 站点ID 精确匹配
    Page<CmsPage> findBySiteId(String siteId, Pageable pageable);
    // 模板ID精确匹配
    Page<CmsPage> findByTemplateId(String tempateId, Pageable pageable);
    // 根据页面名称、站点id、页面访问路径查询
    CmsPage findByPageNameAndSiteIdAndPageWebPath(String pageName,String siteId,String pageWebPath);



}
