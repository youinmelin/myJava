package com.xuecheng.manage_course.Service;

import com.xuecheng.framework.domain.course.ext.CategoryNode;
import com.xuecheng.manage_course.dao.CategoryNodeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    CategoryNodeMapper categoryNodeMapper;

    public CategoryNode findAllCategoryNode() {
        CategoryNode allCategoryNode = categoryNodeMapper.findAllCategoryNode();
        return allCategoryNode;
    }

}
