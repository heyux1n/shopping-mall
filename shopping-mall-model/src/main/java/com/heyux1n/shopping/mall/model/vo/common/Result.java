package com.heyux1n.shopping.mall.model.vo.common;

import lombok.Data;

@Data
public class Result<T> {

    //返回码
    private Integer code;

    //返回消息
    private String message;

    //返回数据
    private T data;

    // 私有化构造
    private Result() {}

    // 返回数据
    public static <T> Result<T> build(T body, Integer code, String message) {
        Result<T> result = new Result<>();
        result.setData(body);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static <T> Result build(T body , ResultCodeEnum resultCodeEnum) {
        return build(body , resultCodeEnum.getCode() , resultCodeEnum.getMessage()) ;
    }

    public static <T> Result build(ResultCodeEnum resultCodeEnum) {
        return build(null , resultCodeEnum.getCode() , resultCodeEnum.getMessage()) ;
    }
}