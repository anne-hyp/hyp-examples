package cn.hehe.springcloudalibaba.sentinel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @author hyp
 * @title: TestController
 * @projectName hyp-examples
 * @description: 测试控制器
 * @date 2022/3/25 14:56
 */
@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("user/{id}")
    public String getUser(@PathVariable("id") String id){
        if (Objects.equals("1", id)) {
            throw new RuntimeException();
        }
        return "hello " + id;
    }

    @GetMapping
    public String test(){
        return "hello";
    }

}
