package demo17Object;

public class Student {
    private String name;
    private int age;

    @Override
    public boolean equals(Object obj) {
        Student stu = (Student) obj;
        if (this.name == stu.name) {
            return true;
        }else{
            return false;
        }
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student() {
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
}
