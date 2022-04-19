package cn.hehe.examples.others.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author hyp
 * @title: JwtIgnore
 * @projectName hyp-examples
 * @description: 控制是否忽略JWT校验注解
 * @date 2022/4/19 18:58
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface JwtIgnore {

    boolean value() default true;
}
