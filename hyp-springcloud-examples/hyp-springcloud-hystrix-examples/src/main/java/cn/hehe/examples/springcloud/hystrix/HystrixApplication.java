package cn.hehe.examples.springcloud.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author hyp
 * @title: hystrixApplication
 * @projectName hyp-examples
 * @description: Hystrix测试模块启动类
 * @date 2022/3/25 11:08
 */
@SpringBootApplication
public class HystrixApplication {

    public static void main(String[] args){
        SpringApplication.run(HystrixApplication.class, args);
    }

}
