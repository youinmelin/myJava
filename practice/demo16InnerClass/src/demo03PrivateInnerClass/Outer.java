package demo03PrivateInnerClass;

public class Outer {

    private int num;

    public Outer(int num) {
        this.num = num;
    }

    public Outer() {
    }

    // 内部类一般都是私有的,需要通过外部类的公有方法创建内部类对象使用
    private class Inner {
        void show() {
            System.out.println(num);
        }
    }

    public void method () {
        Inner inner = new Inner();
        inner.show();
    }
}
