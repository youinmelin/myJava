package com.lin.service;

import com.lin.mapper.FileMsgMapper;
import com.lin.pojo.FileMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileMsgService {

    @Autowired
    private FileMsgMapper fileMsgMapper;

    public List<FileMsg> queryAllFileMsg() {
        return fileMsgMapper.selectAll();
    }
}
