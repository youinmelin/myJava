package lin.mapper;

import lin.pojo.Student;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface StuMapper extends Mapper<Student>{
}
