package cn.hehe.springcloudalibaba.sentinel.exception;

import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author hyp
 * @title: GrobalExceptionHandler
 * @projectName hyp-examples
 * @description: 全局异常处理器
 * @date 2022/3/25 15:52
 */
@ControllerAdvice
public class GrobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public String exceptionHandler(Exception e){
        return "服务器异常！";
    }

}
