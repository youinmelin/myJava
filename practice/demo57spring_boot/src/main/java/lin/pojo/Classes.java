package lin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@Table(name="class")
public class Classes {
    @Id
    @KeySql(useGeneratedKeys = true)
    Integer cid;
    String classname;
    Integer monitor_sid;
    Integer masterteacher_id;
}
