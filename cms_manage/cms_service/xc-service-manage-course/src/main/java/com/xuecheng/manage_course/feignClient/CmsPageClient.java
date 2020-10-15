package com.xuecheng.manage_course.feignClient;

import com.xuecheng.framework.domain.cms.CmsPage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 使用feign 自定义接口,注入IOC容器,供ribbon调用
 * 写明
 * 1.访问类型GetMappring,
 * 2.访问地址,
 * 3.调用的服务名
 */
@FeignClient(value = "XcServiceManageCms")  //指定要调用的服务名
public interface CmsPageClient {
    // 根据页面id查询页面数据信息,通过远程调用cms模块,获取数据
    @GetMapping("/cms/page/getCmsPage/{id}") // 用GetMapping来确认远程调用http的方法类型
    public CmsPage findCmsPageById(@PathVariable("id") String id);
}
