package athlete_coach;

public abstract class Person {
    private String name;
    private int age;

    public abstract void eat();
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {

        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Person() {

    }

    public Person(String name, int age) {

        this.name = name;
        this.age = age;
    }
}
