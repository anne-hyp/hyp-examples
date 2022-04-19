package cn.hehe.examples.others.controller;

import cn.hehe.examples.others.annotation.JwtIgnore;
import cn.hehe.examples.others.dto.UserDto;
import cn.hehe.examples.others.model.User;
import cn.hehe.examples.others.utils.JWTUtils;
import cn.hehe.examples.others.vo.UserTokenVO;
import cn.hutool.core.bean.BeanUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @author hyp
 * @title: AuthController
 * @projectName hyp-examples
 * @description: 权限控制器
 * @date 2022/4/19 16:48
 */
@RestController
public class AuthController {

    @JwtIgnore
    @GetMapping("login")
    public String login(UserDto user, HttpServletResponse response){

        //根据user参数查询数据库，这里做例子，暂时先写死
        User userInfo = new User("1","hyp","123456");

        if (Objects.isNull(userInfo)) {
            return "无该用户！";
        }

        if (!Objects.equals(userInfo.getPassword(), user.getPassword())) {
            return "用户名或者密码错误！";
        }

        UserTokenVO userToken = new UserTokenVO();
        BeanUtil.copyProperties(user, userToken);

        String token = JWTUtils.createToken(userToken);

        response.setHeader(JWTUtils.AUTH_HEADER_KEY, token);

        return "登录成功！";
    }

    @GetMapping("auth")
    public String testAuth(){
        return "成功调用Auth方法！";
    }

}
