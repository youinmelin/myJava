package com.lin.domain;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * 存储课程计划的树形结构
 * 前端页面需要树型结构的数据来展示Tree组件，如下：
   [{
       id: 1,
       label: '一级 1',
       children: [{
         id: 4,
         label: '二级 1‐1'
        }]
      }]
 * Created by admin on 2018/2/7.
 */
@Data
@ToString
public class TeachplanNode extends Teachplan {

    List<TeachplanNode> children;

}
