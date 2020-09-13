package com.lin.pojo;

import lombok.ToString;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@ToString
@Table(name = "file_msg")
public class FileMsg {
    @Id
    @KeySql(useGeneratedKeys = true )
    private Integer msgid;
    private Integer uid;
    private String message;
    private String filename;
    private Integer filesize;
    private Date datetime;
}
