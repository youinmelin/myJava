package lin.proxy;

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
                涉及Proxy类
                JDK提供
                创建代理对象
                使用Proxy类中的newProxyInstance()
            基于子类的动态代理
         */
//        producer.saleProduct(10000f);

        IProducer proxyProducer = (IProducer)Proxy.newProxyInstance(producer.getClass().getClassLoader(),
                producer.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 作用：执行被代理对象的任何接口方法都会经过该方法
                     * @param proxy 代理对象的引用
                     * @param method 当前执行的方法
                     * @param args 当前执行方法所需的参数
                     * @return 和被代理对象有相同的返回值
                     * @throws Throwable
                     */
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //提供增强的代码
                        Float money= (Float)args[0];
                        Object returnValue = null;
                        if("saleProduct".equals(method.getName())) {
                             returnValue = method.invoke(producer, money*0.8f);
                        }
                        return returnValue;
                    }
                });
        proxyProducer.saleProduct(10000f);
    }
}
