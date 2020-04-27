package demo16InnerClass;

public class Outer2 {
    public void outerMethod() {
        System.out.println("execute outerMethod.");

        class InnerClass {
            String innerString = "innerString";
            public void innerMethod() {
                System.out.println("execute innderMethod.");
            }
        }

        InnerClass inner = new InnerClass();
        System.out.println(inner.innerString);
        inner.innerMethod();
    }
}