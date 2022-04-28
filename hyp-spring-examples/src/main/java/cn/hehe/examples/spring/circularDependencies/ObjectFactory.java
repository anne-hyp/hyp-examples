package cn.hehe.examples.spring.circularDependencies;

import org.springframework.beans.BeansException;

/**
 * @author hyp
 * @title: ObjectFactory
 * @description: TODO
 * @date 2022/4/23 10:46
 */
@FunctionalInterface
public interface ObjectFactory<T> {

    /**
     * Return an instance (possibly shared or independent)
     * of the object managed by this factory.
     * @return the resulting instance
     * @throws BeansException in case of creation errors
     */
    T getObject() throws BeansException;

}
