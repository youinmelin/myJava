package com.lin.controller;

import com.lin.pojo.FileMsg;
import com.lin.service.FileMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/filemsg")
public class FileMsgController {

    @Autowired
    FileMsgService fileMsgService;

    @RequestMapping("/all")
    public String queryAllFileMsg(Map<String, Object> map) {
        List<FileMsg> fileMsgs = fileMsgService.queryAllFileMsg();
        map.put("fileMsg", fileMsgs);
        map.put("welcome", "欢迎使用文件系统");
        return "file_msg";
    }

}
