package demo02;

public class InnerDemo {
    public static void main(String[] args) {
        Outer outer = new Outer();
        // 创建内部类对象
        // 格式: 外部类名.内部类名 对象名 = 外部类对象.内部类对象
        Outer.Inner inner = outer.new Inner();
        inner.show();
    }
}
