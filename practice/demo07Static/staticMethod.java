package demo07Static;

public class staticMethod {
    public static void main(String[] args) {
        MyClass newClass = new MyClass();
        newClass.method();
        MyClass.methodStatic();
    }
}