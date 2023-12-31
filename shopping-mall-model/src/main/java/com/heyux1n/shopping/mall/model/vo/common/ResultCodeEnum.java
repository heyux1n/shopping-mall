package com.heyux1n.shopping.mall.model.vo.common;

import lombok.Getter;

/**
 * @author: heyux1n
 * @date: 2023/11/5 14:41
 * @description:
 * @version: 1.0.0
 */
@Getter
public enum ResultCodeEnum {

    /**
     * 操作成功
     */
    SUCCESS(200 , "操作成功") ,
    USER_UNREGISTERED(201 , "用户未注册") ,
    CAPTCHA_ERROR(202 , "验证码错误") ,
    LOGIN_ERROR(203 , "用户名或者密码错误"),

    USER_NAME_IS_EXISTS(209 , "用户名已经存在"),
    NODE_ERROR( 217, "该节点下有子节点，不可以删除"),
    DATA_ERROR(204, "数据异常"),
    ACCOUNT_STOP( 216, "账号已停用"),
    STOCK_LESS( 219, "库存不足"),

    LOGIN_AUTH(401 , "用户未登录"),
    SYSTEM_ERROR(9999 , "您的网络有问题请稍后重试"),


    CATEGORY_IMPORT_ERROR(111, "分类导入失败"),
    CATEGORY_EXPORT_ERROR(112, "分类导出失败"),
    ;


    /**
     * 业务状态码
     */
    private Integer code;
    /**
     * 响应消息
     */
    private String message;

    private ResultCodeEnum(Integer code , String message) {
        this.code = code ;
        this.message = message ;
    }

}
