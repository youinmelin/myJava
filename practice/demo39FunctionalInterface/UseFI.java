package demo39FunctionalInterface;

public class UseFI {
    public static void show(FunctionalInterface01 myInter) {
        myInter.method();
    }
    public static void main(String[] args) {
        FunctionalInterface01 myInter = new FunctionalInterface01Impl();
        show(myInter);

        show(() -> System.out.println("use Lambda override method"));

        show(new FunctionalInterface01(){
        
            @Override
            public void method() {
                System.out.println("use anonymous inner class override method");
            }
        });
    }
}