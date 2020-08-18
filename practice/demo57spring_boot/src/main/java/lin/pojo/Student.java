package lin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

@Data  // 自动创建getter/setter/toString等方法
@AllArgsConstructor  // 自动创建全参构造函数
@Table(name = "students")  // 定义应对应的数据库表名
public class Student {
    @Id  // 定义主键
    @KeySql(useGeneratedKeys = true) // 自增长
    Integer sid;
    String name;
    Integer number;
    String gender;
    Integer cid;

}
