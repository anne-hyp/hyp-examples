package cn.hehe.examples.others.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author hyp
 * @title: UserDto
 * @projectName hyp-examples
 * @description: 接收前端用户信息类
 * @date 2022/4/19 16:51
 */
@Data
public class UserDto {

    private String id;

    private String userName;

    private String password;

}
