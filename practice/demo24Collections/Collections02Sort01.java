package demo24Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Collections02Sort01 {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("Nasa", 8));
        list.add(new Student("Papa", 70));
        list.add(new Student("Youinme", 20));
        list.add(new Student("Golin", 30));
        Collections.sort(list);
        System.out.println(list);
    }
}