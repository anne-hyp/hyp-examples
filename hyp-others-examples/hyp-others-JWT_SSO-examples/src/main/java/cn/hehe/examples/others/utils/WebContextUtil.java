package cn.hehe.examples.others.utils;

import cn.hehe.examples.others.vo.UserTokenVO;

/**
 * @author hyp
 * @title: WebContextUtil
 * @projectName hyp-examples
 * @description: 存储token中的用户信息
 * @date 2022/4/19 16:36
 */
public class WebContextUtil {

    //本地线程缓存token
    private static ThreadLocal<UserTokenVO> local = new ThreadLocal<>();

    /**
     * 设置token信息
     */
    public static void setUserToken(UserTokenVO userTokenVO){
        removeUserToken();
        local.set(userTokenVO);
    }

    /**
     * 获取token信息
     * @return
     */
    public static UserTokenVO getUserToken(){
        if(local.get() != null){
            UserTokenVO userMsg = local.get();
            return userMsg;
        }
        return null;
    }

    /**
     * 移除token信息
     * @return
     */
    public static void removeUserToken(){
        if(local.get() != null){
            local.remove();
        }
    }
}
