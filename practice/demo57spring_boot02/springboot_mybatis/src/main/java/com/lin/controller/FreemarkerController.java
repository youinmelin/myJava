package com.lin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class FreemarkerController {

    @RequestMapping("/freemarker")
    public String testFreemarker(Map<String, Object> map) {
        return "json_freemarker";
    }
}
