package demo07Static;

public class Person {
    static {
        System.out.println("静态方法执行");
    }
    public Person() {
        System.out.println("构造方法执行");
    }
}