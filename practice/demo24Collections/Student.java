package demo24Collections;

public class Student implements Comparable<Student> {
    private String name ;
    private int age;

    @Override
    public String toString() {
        return "Student [age=" + age + ", name=" + name + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Student o) {
        // TODO Auto-generated method stub
        return this.getAge() - o.getAge();
    }

    
}