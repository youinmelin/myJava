package lin;

import lin.pojo.Student;
import org.junit.Test;

public class TestLombok {
    @Test
    public void testStu(){
        Student student = new Student(3,"aa", 1,"male", 1, null);
        System.out.println(student);
        student.setName("bb");
        System.out.println(student.getName());

    }
}
