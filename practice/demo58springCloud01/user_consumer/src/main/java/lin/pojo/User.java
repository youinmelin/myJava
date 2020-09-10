package lin.pojo;

import lombok.Data;
import java.util.Date;

@Data
public class User {

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
