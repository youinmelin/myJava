package demo05AnonymousClass;

/*
匿名内部类
    前提:存在一个类(一般是抽象类)或者接口
    本质:是一个继承抽象类或者实现接口的子类的匿名对象(没有名字,只使用一次)
    格式:
        new 类名/接口名() {
            重写方法;
        };
 */
public class Outer {

    public void method() {
        // 匿名内部类
        new Inter() {
            @Override
            public void show() {
                System.out.println("匿名内部类");
            }
        }.show();

        // 多态,接口引用了实现类
        Inter inter = new Inter() {
            @Override
            public void show() {
                System.out.println("anonymous class");
            }
        };
        inter.show();

    }
}
