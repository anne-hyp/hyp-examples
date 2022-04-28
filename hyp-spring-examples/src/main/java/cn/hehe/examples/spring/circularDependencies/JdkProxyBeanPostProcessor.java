package cn.hehe.examples.spring.circularDependencies;

import org.springframework.aop.framework.AopProxy;
import org.springframework.aop.framework.AopProxyFactory;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.aop.framework.DefaultAopProxyFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author hyp
 * @title: JdkProxyBeanPostProcessor
 * @description: TODO
 * @date 2022/4/23 10:46
 */
//@Component
public class JdkProxyBeanPostProcessor implements SmartInstantiationAwareBeanPostProcessor {

	public Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {

		// 假设:A 被切点命中 需要创建代理  @PointCut("execution(* *..InstanceA.*(..))")
		if(bean instanceof InstanceA) {
			JdkDynimcProxy jdkDynimcProxy = new JdkDynimcProxy(bean);
			return  jdkDynimcProxy.getProxy();
		}
		return bean;
	}
}
