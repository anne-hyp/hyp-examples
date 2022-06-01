package cn.hehe.examples.javase.reflect;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author hyp
 * @title: CGLIBDynamicProxyTest
 * @projectName hyp-examples
 * @description: CGLIB动态代理
 * @date 2022/5/24 11:36
 */
public class CGLIBDynamicProxyTest {

    public static class Target {
        public Target(){
            System.out.println("Target 构建方法！");
        }

        final public void noProxyMethod(){
            System.out.println("noProxyMethod 执行！");
        }

        public void proxyMethod(){
            System.out.println("proxyMethod 执行！");
        }
    }

    static class MyMethodInterceptor implements MethodInterceptor {

        public void before() {
            System.out.println("do something before!");
        }

        public void after() {
            System.out.println("do something after!");
        }

        public static <T> T getProxy(Class clazz){
            Enhancer enhacer = new Enhancer();
            // 设置enhancer对象的父类
            enhacer.setSuperclass(clazz);
            // 设置enhancer的回调对象
            enhacer.setCallback(new MyMethodInterceptor());
            return (T) enhacer.create();
        }

        /**
         * sub：cglib生成的代理对象
         * method：被代理对象方法
         * objects：方法入参
         * methodProxy: 代理方法
         */
        @Override
        public Object intercept(Object sub, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            before();
            Object object = methodProxy.invokeSuper(sub, objects);
            after();
            return object;
        }

    }

    public static void main(String[] args){
        Target proxy = MyMethodInterceptor.getProxy(Target.class);
        //该方法无法使用CGLIB动态代理,因为使用了final参数修饰方法
        proxy.noProxyMethod();
        proxy.proxyMethod();
    }

}
