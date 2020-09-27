package demo02;
/*
内部类可以直接访问外部类的成员,包括私有
外部类要访问内部类的成员,必须创建对象
 */
public class Outer {

    private int num = 10;

    public void method() {
        Inner inner = new Inner();
        inner.show();
    }

    // 成员内部类
    public class Inner {

        public void show () {
            System.out.println(num);
        }
    }

}
