package com.xuecheng.manage_cms.service;

import com.xuecheng.framework.domain.system.SysDictionary;
import com.xuecheng.framework.exception.ExceptionCast;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.manage_cms.controller.SysDictController;
import com.xuecheng.manage_cms.dao.SysDictRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.SynchronousQueue;

@Service
public class SysDictService {

    @Autowired
    SysDictRepository sysDictRepository;

    public SysDictionary getSysDictByType(String type) {
        if (StringUtils.isEmpty(type)) {
            ExceptionCast.cast(CommonCode.INVALID_PARAM);
        }
        SysDictionary sysDictionary = sysDictRepository.getByDType(type);
        return sysDictionary;
    }
}
