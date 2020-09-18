package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.CmsPageParam;
import com.xuecheng.framework.domain.cms.response.CmsPageResult;
import com.xuecheng.framework.model.response.QueryResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CmsPageRepositoryTest {

    @Autowired
    CmsPageRepository cmsPageRepository;

    @Test
    public void testFindAll(){
        List<CmsPage> all = cmsPageRepository.findAll();
        System.out.println(all);
    }

    // 测试分页查询
    @Test
    public void testFindPage(){
        // 定义页数，从零开始
        Integer page = 0;
        Integer size = 10;
        // org.springframework.data.domain.Pageable
        Pageable pageable = PageRequest.of(page, size);
        Page<CmsPage> all = cmsPageRepository.findAll(pageable);
        System.out.println(all);
    }

    // test insert data
    @Test
    public void testInsert() {
        CmsPage cmsPage = new CmsPage();
        cmsPage.setSiteId("s01");
        cmsPage.setTemplateId("t01");
        cmsPage.setPageName("test page");
        cmsPage.setPageCreateTime(new Date());
        List<CmsPageParam> cmsPageParams = new ArrayList<>();
        CmsPageParam cmsPageParam = new CmsPageParam();
        cmsPageParam.setPageParamName("param1");
        cmsPageParam.setPageParamValue("value1");
        cmsPageParams.add(cmsPageParam);
        cmsPage.setPageParams(cmsPageParams);
        cmsPageRepository.save(cmsPage);
        System.out.println(cmsPage);
    }

    @Test
    public void testUpdate(){

        // Optional是一个容器对象，它包括了我们需要的对象，使用isPresent方法判断所包
        // 含对象是否为空，isPresent方法返回false则表示Optional包含对象为空，否则可以使用get()取出对象进行操作。
        Optional<CmsPage> optional = cmsPageRepository.findById("5f62ad63370608070cf366a5");
        // 判断是否为空
        if (optional.isPresent()) {
            // 查询对象
            CmsPage cmsPage = optional.get();
            // 设置要修改的值
            cmsPage.setPageAliase("test01");
            // 提交修改
            CmsPage save = cmsPageRepository.save(cmsPage);
            System.out.println(save);
        }
    }

    // 根据页面名称查询
    @Test
    public void testFindbyPageName() {
        CmsPage byPageName = cmsPageRepository.findByPageName("preview_402885816243d2dd016243f24c030002.html");
        System.out.println(byPageName);
    }

    // 自定义条件查询测试
    @Test
    public void testFindAllByExample() {
        // 定义页数，从零开始
        Integer page = 0;
        Integer size = 10;
        Pageable pageable = PageRequest.of(page, size);
        // 条件值对象,如果不设置属性，就查询全部
        CmsPage cmsPage = new CmsPage();
        // 设置查询条件：siteID
        cmsPage.setSiteId("5a751fab6abb5044e0d19ea1");
        // 设置查询条件：templateID
        cmsPage.setTemplateId("5a925be7b00ffc4b3c1578b5");
        // 设置页面别名：pageAliase, 通过ExampleMatcher设置模糊查询
        // ExampleMatcher.GenericPropertyMatchers.contains() 包含关键字
        // ExampleMatcher.GenericPropertyMatchers.startsWith() 前缀匹配
        // ExampleMatcher.GenericPropertyMatchers.endsWith() 后缀匹配
        // ExampleMatcher.GenericPropertyMatchers.ignoreCase()
        // ExampleMatcher.GenericPropertyMatchers.caseSensitive()
        // ExampleMatcher.GenericPropertyMatchers.exact()
        // ExampleMatcher.GenericPropertyMatchers.regex()
        cmsPage.setPageAliase("课程");
        // 条件匹配器ExampleMatcher
        ExampleMatcher exampleMatcher = ExampleMatcher.matching();
        exampleMatcher = exampleMatcher.withMatcher("pageAliase", ExampleMatcher.GenericPropertyMatchers.contains());
        // 定义 Example
        Example<CmsPage> example = Example.of(cmsPage, exampleMatcher);
        Page<CmsPage> cmsPages = cmsPageRepository.findAll(example, pageable);
        List<CmsPage> content = cmsPages.getContent();
        System.out.println(content);
    }
}
