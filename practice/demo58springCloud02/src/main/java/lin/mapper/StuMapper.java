package lin.mapper;

import lin.pojo.Student;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StuMapper extends tk.mybatis.mapper.common.Mapper<Student> {

    @Select("select * from students")
    @Results(id = "AllStuWithClass", value = {
            @Result(id = true, property = "sid", column = "sid"),
            @Result(property = "name", column = "name"),
            @Result(property = "number", column = "number"),
            @Result(property = "gender", column = "gender"),
            @Result(property = "classes", column = "cid",
                    one = @One(select = "lin.mapper.ClassesMapper.selectByPrimaryKey"))
    })
    public List<Student> selectAllStuWithClass();

    @Select("select * from students where sid = #{sid}")
    @Results(id = "StuWithClassBySId", value = {
            @Result(id = true, property = "sid", column = "sid"),
            @Result(property = "name", column = "name"),
            @Result(property = "number", column = "number"),
            @Result(property = "gender", column = "gender"),
            @Result(property = "classes", column = "cid",
                    one = @One(select = "lin.mapper.ClassesMapper.selectByPrimaryKey"))
    })
    public Student selectStuWithClassBySId(Integer sid);
}
