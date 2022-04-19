package cn.hehe.examples.others.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hyp
 * @title: user
 * @projectName hyp-examples
 * @description: 用户持久化类
 * @date 2022/4/19 19:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String id;

    private String userName;

    private String password;

}
