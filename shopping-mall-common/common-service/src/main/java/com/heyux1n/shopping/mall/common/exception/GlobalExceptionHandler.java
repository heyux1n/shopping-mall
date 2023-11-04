package com.heyux1n.shopping.mall.common.exception;

import com.heyux1n.shopping.mall.common.exception.ServiceResException;
import com.heyux1n.shopping.mall.model.vo.common.Result;
import com.heyux1n.shopping.mall.model.vo.common.ResultCodeEnum;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: heyux1n
 * @date: 2023/10/29 11:09
 * @description:
 * @version: 1.0.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    @ResponseBody
    public Result error(Exception e) {
        return Result.build(ResultCodeEnum.SYSTEM_ERROR);
    }


    @ExceptionHandler
    @ResponseBody
    public Result error(ServiceResException e) {
        return Result.build(e.getResultCodeEnum());
    }
}
