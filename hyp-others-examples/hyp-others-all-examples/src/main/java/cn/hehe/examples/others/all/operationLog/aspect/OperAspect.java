package cn.hehe.examples.others.all.operationLog.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author hyp
 * @title: OperAspect
 * @projectName hyp-examples
 * @description: 操作日志AOP切面
 * @date 2022/6/28 17:56
 */
@Aspect
@Component
public class OperAspect {

    @Pointcut("@annotation(cn.hehe.examples.others.all.operationLog.annotation.OperLog)")
    public void pointcut(){}



}
