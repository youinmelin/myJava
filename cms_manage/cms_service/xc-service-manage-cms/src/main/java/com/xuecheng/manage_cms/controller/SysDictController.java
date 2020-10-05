package com.xuecheng.manage_cms.controller;

import com.xuecheng.api.cms.SysDictionaryControllApi;
import com.xuecheng.framework.domain.system.SysDictionary;
import com.xuecheng.manage_cms.service.SysDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
@RequestMapping("/sys/dictionary/")
public class SysDictController implements SysDictionaryControllApi{
    @Autowired
    SysDictService sysDictService;

    @Override
    @GetMapping("/get/{dType}")
    public SysDictionary getSysDictByType(@PathVariable("dType") String type) {
        return sysDictService.getSysDictByType(type);
    }
}
