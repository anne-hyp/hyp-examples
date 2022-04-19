package cn.hehe.examples.others.utils;

import cn.hehe.examples.others.vo.UserTokenVO;
import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.Claim;

import java.util.Date;
import java.util.Map;

/**
 * @author hyp
 * @title: JWTUtils
 * @projectName hyp-examples
 * @description: JWT工具类
 * @date 2022/4/19 16:11
 */
public class JWTUtils {

    //Token前缀
    public static final String TOKEN_PREFIX = "Bearer ";

    //定义Token返回头部
    public static final String AUTH_HEADER_KEY = "Authorization";

    //签名秘钥
    public static final String KEY = "q3t6w9z$C&F)J@NcQfTjWnZr4u7x";

    //有效期默认为2小时
    public static final Long EXPIRATION_TIME = 1000L*60*60*2;

    public static String createToken(UserTokenVO user){
        return TOKEN_PREFIX + JWT.create()
                //在载荷中放入用户信息
                .withClaim("id", user.getId())
                .withClaim("userName", user.getUserName())
                //设置过期时间
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                //设置秘钥
                .sign(Algorithm.HMAC512(KEY));
    }

    /**
     * 验证Token
     * @param token
     * @return
     */
    public static UserTokenVO checkToken(String token) throws Exception {
        UserTokenVO userToken = null;
        if (StrUtil.isBlank(token)){
            return userToken;
        }
        try {
            Map<String, Claim> claims = JWT.require(Algorithm.HMAC512(KEY))
                    .build()
                    .verify(token.replace(TOKEN_PREFIX, ""))
                    .getClaims();
            userToken = new UserTokenVO(claims.get("id").asString(), claims.get("userName").asString());
        } catch (TokenExpiredException e) {
            throw new Exception("token已失效，请重新登录",e);
        } catch (JWTVerificationException e) {
            throw new Exception("token验证失败！",e);
        }
        return userToken;
    }

}
