package lin.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data  // use lombok, create getter setter toString ...automatically
@Component
@Table(name = "tb_user")  // define table name in the datebase
public class User {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private String user_name;
    private String password;
    private String name;
    private Integer age;
    private Integer sex;
    private Date birthday;
    private String note;
    private Date created;
    private Date updated;
}
