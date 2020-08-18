package lin.cglib;

import lin.proxy.IProducer;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
a consumer
 */
public class Client {
    public static void main(String[] args) {
        // 匿名内部类访问外部成员，需要final修饰
        final Producer producer = new Producer();
        /*
        动态代理，
        特点：字节码随用随创建，随用随加载
        作用：不修改源码的基础上对方法增强
        分类：
            基于接口的动态代理
            基于子类的动态代理:
                涉及Enhancer
                cglib提供
                创建代理对象
                使用Enhancer类中的create()
                被代理的类不能是最终类（太监类）
         */
//        producer.saleProduct(10000f);
        Producer cglibProducer = (Producer)Enhancer.create(producer.getClass(), new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Object returnValue = null;
                Float money = (Float) objects[0];
                if ("saleProduct".equals(method.getName())) {
                    returnValue = method.invoke(producer, money * 0.8f);
                }
                return returnValue;
            }
        });
        cglibProducer.saleProduct(10000);
    }
}
