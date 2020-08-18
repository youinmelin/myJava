package lin.pojo;

import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "students")
public class Student {
    Integer sid;
    String name;
    Integer number;


}
