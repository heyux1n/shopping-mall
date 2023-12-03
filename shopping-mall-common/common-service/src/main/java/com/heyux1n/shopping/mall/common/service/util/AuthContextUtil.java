package com.heyux1n.shopping.mall.common.service.util;

import com.heyux1n.shopping.mall.model.entity.h5.UserInfo;

/**
 * @author: heyux1n
 * @date: 2023/12/3 20:29
 * @description:
 * @version: 1.0.0
 */
public class AuthContextUtil {
    private static final ThreadLocal<UserInfo> USERINFO_THREAD_LOCAL = new ThreadLocal<>() ;


    /**
     * 定义存储数据的静态方法
     * @param userInfo
     */
    public static void setUserInfo(UserInfo userInfo) {
        USERINFO_THREAD_LOCAL.set(userInfo);
    }

    /**
     * 定义获取数据的方法
     * @return
     */
    public static UserInfo getUserInfo() {
        return USERINFO_THREAD_LOCAL.get() ;
    }

    /**
     * 删除数据的方法
     */
    public static void removeUserInfo() {
        USERINFO_THREAD_LOCAL.remove();
    }
}
