package demo04LocalInnerClass;

// 局部内部类
// 通过成员方法间接调用,在方法内部创建内部类对象后再使用
public class Outer {
    private int num = 10;
    public void method() {

        int num2 = 20;

        class Inner {
            public void show () {
                System.out.println(num);
                System.out.println(num2);
            }
        }
        Inner inner = new Inner();
        inner.show();

    }

}
