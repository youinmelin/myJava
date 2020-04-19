package demo10Extends;

public class Teacher extends Employee {
    int zi = 20;
    int num = 200;
    public void method() {
        int num = 300;
        System.out.println(num);
        System.out.println(this.num);
        System.out.println(super.num);
    }
    @Override
    public void begin() {
        System.out.println("teacher method begin.");
    }
}