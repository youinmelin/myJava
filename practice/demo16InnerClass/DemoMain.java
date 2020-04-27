package demo16InnerClass;

public class DemoMain {
    public static void main(String[] args) {
        Interface impl = new InterfaceImpl();
        impl.methodAbs();

    Interface inter = new Interface() {
        @Override
        public void methodAbs() {
            System.out.println("Inner Class override method A");
        }
    };
    inter.methodAbs();

    new Interface() {
        @Override
        public void methodAbs() {
            System.out.println("Inner Class override method B");
        }
    }.methodAbs();
}
}