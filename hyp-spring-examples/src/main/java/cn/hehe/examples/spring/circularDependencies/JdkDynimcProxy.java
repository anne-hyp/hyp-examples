package cn.hehe.examples.spring.circularDependencies;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author hyp
 * @title: JdkDynimcProxy
 * @description: TODO
 * @date 2022/4/23 10:39
 */
public class JdkDynimcProxy implements InvocationHandler {

	private Object target;

	public JdkDynimcProxy(Object target) {
		this.target = target;
	}

	public <T> T getProxy() {
		return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("测试");
		return method.invoke(target,args);
	}
}
