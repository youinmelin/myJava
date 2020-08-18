package lin.service;

import lin.mapper.StuMapper;
import lin.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StuService {
    @Autowired
    StuMapper stuMapper;
    public List<Student> selectAllStu() {
        System.out.println("BLL: all");
        return stuMapper.selectAll();
    }
}
