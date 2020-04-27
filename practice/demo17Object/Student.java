package demo17Object;

public class Student {
    private String name;
    private int age;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            Student stu = (Student) obj;
            boolean same = this.name.equals(stu.name); 
            return same;
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
