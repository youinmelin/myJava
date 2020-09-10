package com.lin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
@Slf4j
public class JdbcController {

    @Autowired
    private DataSource dataSource;

    @RequestMapping("/jdbc")
    public String queryById(Integer id) {
        log.info("DataSource: " + dataSource);
        return "hello JDBC";
    }

}
