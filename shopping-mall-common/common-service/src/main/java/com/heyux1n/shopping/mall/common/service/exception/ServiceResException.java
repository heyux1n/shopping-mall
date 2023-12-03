package com.heyux1n.shopping.mall.common.service.exception;

import com.heyux1n.shopping.mall.model.vo.common.ResultCodeEnum;
import lombok.Getter;

/**
 * @author ：heyux1n
 * @date ： 2023/10/29 11:02
 * @description：
 * @version: 1.0.0
 */
@Getter
public class ServiceResException extends RuntimeException{
    private Integer code;
    private String message;
    private ResultCodeEnum resultCodeEnum;

    public ServiceResException(ResultCodeEnum resultCodeEnum) {
        this.code = resultCodeEnum.getCode();
        this.message = resultCodeEnum.getMessage();
        this.resultCodeEnum = resultCodeEnum;
    }
}
