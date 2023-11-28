package com.heyux1n.shopping.mall.common.log.annotation;

import com.heyux1n.shopping.mall.common.log.enums.OperatorType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: heyux1n
 * @date: 2023/11/28 21:17
 * @description:
 * @version: 1.0.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {
    /**
     * 模块名称
     *
     * @return
     */
    public String title();

    /**
     * 操作人类别
     *
     * @return
     */
    public OperatorType operatorType() default OperatorType.MANAGE;

    /**
     * 业务类型（0其它 1新增 2修改 3删除）
     *
     * @return
     */
    public int businessType();

    /**
     * 是否保存请求的参数
     *
     * @return
     */
    public boolean isSaveRequestData() default true;

    /**
     * 是否保存响应的参数
     *
     * @return
     */
    public boolean isSaveResponseData() default true;
}
