package com.heyux1n.shopping.mall.common.util;

import com.heyux1n.shopping.mall.model.entity.system.SysUser;

/**
 * @author: heyux1n
 * @date: 2023/10/30 21:17
 * @description:
 * @version: 1.0.0
 */
public class AuthContextUtil {
    // 创建一个ThreadLocal对象
    private static final ThreadLocal<SysUser> threadLocal = new ThreadLocal<>() ;

    // 定义存储数据的静态方法
    public static void set(SysUser sysUser) {
        threadLocal.set(sysUser);
    }

    // 定义获取数据的方法
    public static SysUser get() {
        return threadLocal.get() ;
    }

    // 删除数据的方法
    public static void remove() {
        threadLocal.remove();
    }
}
