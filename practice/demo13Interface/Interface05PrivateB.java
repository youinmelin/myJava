package demo13Interface;

public interface Interface05PrivateB {
    public static void methodStatic1() {
        System.out.println("static method 1.");
        commonMethod();
    }
    public static void methodStatic2() {
        System.out.println("static method 2.");
        commonMethod();
    }
    private static void commonMethod() {
        System.out.println("commond method");
    }
}