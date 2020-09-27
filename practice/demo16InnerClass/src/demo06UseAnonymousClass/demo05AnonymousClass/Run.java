package demo06UseAnonymousClass.demo05AnonymousClass;

public class Run {
    public static void main(String[] args) {
        JumppingOperator jumppingOperator = new JumppingOperator();
        jumppingOperator.method(new Jumpping() {
            @Override
            public void jump() {
                System.out.println("jumpping high");
            }
        });
    }
}
