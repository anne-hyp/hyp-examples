package cn.hehe.examples.others.all.operationLog.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author hyp
 * @title: OperLog
 * @projectName hyp-examples
 * @description: 操作日志
 * @date 2022/6/28 17:50
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface OperLog {

    /**
     * 操作方法描述
     * @return
     */
    String eperation()default "";

    /**
     * 异常消息描述
     * @return
     */
    String exceptionMsg() default "操作异常";

}
