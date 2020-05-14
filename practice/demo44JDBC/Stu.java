package demo44JDBC;

public class Stu {
    private int id;
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Stu [age=" + age + ", id=" + id + ", name=" + name + "]";
    }

    public Stu(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Stu() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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