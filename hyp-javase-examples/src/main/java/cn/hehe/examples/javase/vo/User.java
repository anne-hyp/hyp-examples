package cn.hehe.examples.javase.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author hyp
 * @title: User
 * @projectName hyp-examples
 * @description: TODO
 * @date 2022/4/28 16:57
 */
@Data
@AllArgsConstructor
public class User implements Comparable<User> {

    private Integer id;
    private String name;
    private Integer age;
    private String sex;

    @Override
    public int compareTo(User o) {
        return this.getAge().compareTo(o.getAge());
    }
}
