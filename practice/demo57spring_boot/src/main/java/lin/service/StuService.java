package lin.service;

import lin.mapper.StuMapper;
import lin.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StuService {

    @Autowired
    private StuMapper stuMapper;

    public Student queryBySId(Integer sid) {
        System.out.println("BLL:queryBySId. sid = " +  sid);
        Student student = stuMapper.selectByPrimaryKey(sid);
        System.out.println(student);
//        Student student1 = new Student(5, "nancy", 22, "female", 1);
//        System.out.println(student1.getName());
        return student;
    }

    @Transactional
    public void addStudent(Student student) {
        System.out.println("new Student...");
        // 选择性新增，如果属性为空则该属性不会出现在insert语句中
        stuMapper.insertSelective(student);
    }
}
