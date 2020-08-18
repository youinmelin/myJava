package lin.service;

import lin.mapper.StuMapper;
import lin.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StuService {
    @Autowired
    private StuMapper stuMapper;

    @Transactional
    public List selectAll() {
        List<Student> students = stuMapper.selectAll();
        return students;
    }

    public Student selectById(Integer id) {
        Student student = stuMapper.selectByPrimaryKey(id);
        System.out.println("BLL: id=" + id);
        System.out.println(student);
        return student;
    }

    public Student selectStuWithClassBySId(Integer sid){
        Student stu = stuMapper.selectStuWithClassBySId(sid);
        return stu;
    }

    public List selectAllStuWithClass(){
        List stus = stuMapper.selectAllStuWithClass();
        return stus;
    }
}
