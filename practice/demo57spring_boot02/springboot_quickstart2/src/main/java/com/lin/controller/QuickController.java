package com.lin.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class QuickController {

    @RequestMapping("/quick")
    public String quick() {
        return "hello spring boot...";
    }

    @RequestMapping("/findUser")
    public String quick2() throws JsonProcessingException {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("userExsit", false);
        map.put("msg", "用户名可用");
        ObjectMapper objectMapper = new ObjectMapper();
        String str = objectMapper.writeValueAsString(map);
        return str;
    }
}
