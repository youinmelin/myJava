package com.lin.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class Class {
    @Id
    private Integer cid;
    private String classname;
    Integer monitor_sid;
    Integer masterteacher_id;

}
