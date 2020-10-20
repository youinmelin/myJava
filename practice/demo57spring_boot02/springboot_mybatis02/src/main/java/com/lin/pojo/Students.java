package com.lin.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Students {
    @Id
    private Integer sid;
    private String name;
    private Integer number;
    private String gender;
    private Integer cid;
}
