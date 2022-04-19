package cn.hehe.examples.others.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hyp
 * @title: UserTokenVO
 * @projectName hyp-examples
 * @description: 存储在token中的用户信息
 * @date 2022/4/19 16:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserTokenVO {

    private String id;

    private String userName;

}
