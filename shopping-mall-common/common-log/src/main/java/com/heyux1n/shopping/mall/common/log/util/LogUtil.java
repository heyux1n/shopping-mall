package com.heyux1n.shopping.mall.common.log.util;

import com.alibaba.fastjson.JSON;
import com.heyux1n.shopping.mall.common.log.annotation.Log;
import com.heyux1n.shopping.mall.common.util.AuthContextUtil;
import com.heyux1n.shopping.mall.model.entity.system.SysOperateLog;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.http.HttpMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author: heyux1n
 * @date: 2023/11/28 21:16
 * @description:
 * @version: 1.0.0
 */
public class LogUtil {

    /**
     * 操作执行之后调用
     * @param sysLog
     * @param proceed
     * @param sysOperateLog
     * @param status
     * @param errorMsg
     */
    public static void afterHandleLog(Log sysLog, Object proceed,
                                     SysOperateLog sysOperateLog, int status ,
                                     String errorMsg) {
        if(sysLog.isSaveResponseData()) {
            sysOperateLog.setJsonResult(JSON.toJSONString(proceed));
        }
        sysOperateLog.setStatus(status);
        sysOperateLog.setErrorMsg(errorMsg);
    }


    /**
     * 操作执行之前调用
     * @param sysLog
     * @param joinPoint
     * @param sysOperateLog
     */
    public static void beforeHandleLog(Log sysLog,
                                       ProceedingJoinPoint joinPoint,
                                       SysOperateLog sysOperateLog) {

        // 设置操作模块名称
        sysOperateLog.setTitle(sysLog.title());
        sysOperateLog.setOperatorType(sysLog.operatorType().name());

        // 获取目标方法信息
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature() ;
        Method method = methodSignature.getMethod();
        sysOperateLog.setMethod(method.getDeclaringClass().getName());

        // 获取请求相关参数
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        sysOperateLog.setRequestMethod(request.getMethod());
        sysOperateLog.setOperateUrl(request.getRequestURI());
        sysOperateLog.setOperateIp(request.getRemoteAddr());

        // 设置请求参数
        if(sysLog.isSaveRequestData()) {
            String requestMethod = sysOperateLog.getRequestMethod();
            if (HttpMethod.PUT.name().equals(requestMethod) || HttpMethod.POST.name().equals(requestMethod)) {
                String params = Arrays.toString(joinPoint.getArgs());
                sysOperateLog.setOperateParam(params);
            }
        }
        sysOperateLog.setOperateName(AuthContextUtil.get().getUserName());
    }
}
