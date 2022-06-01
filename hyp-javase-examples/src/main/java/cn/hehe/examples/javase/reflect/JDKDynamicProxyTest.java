package cn.hehe.examples.javase.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author hyp
 * @title: JDKDynamicProxyTest
 * @projectName hyp-examples
 * @description: JDK动态代理
 * @date 2022/5/24 11:38
 */
public class JDKDynamicProxyTest {

    /**
     * 被代理接口
     */
    interface Subject {
        void action();
    }

    /**
     * 被代理类
     */
    static class SubjectImpl implements Subject {

        @Override
        public void action(){
            System.out.println("excute action！");
        };

    }

    /**
     * JDK动态代理类
     */
    static class DynamicProxyHandler implements InvocationHandler {

        private Object target;

        public DynamicProxyHandler(Object target){
            this.target = target;
        }

        /**
         * 使用Proxy类生成动态代理类
         * @param <T>
         * @return
         */
        public <T> T getProxy(){
            return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
        }

        public void before() {
            System.out.println("do something before!");
        }

        public void after() {
            System.out.println("do something after!");
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            before();
            method.invoke(target, args);
            after();
            return null;
        }
    }

    public static void main(String[] args){
        Subject proxy = new DynamicProxyHandler(new SubjectImpl()).getProxy();
        proxy.action();
    }

}
