package com.heyux1n.shopping.mall.common.log.aspect;

import com.heyux1n.shopping.mall.common.log.annotation.Log;
import com.heyux1n.shopping.mall.common.log.service.AsyncOperateLogService;
import com.heyux1n.shopping.mall.common.log.util.LogUtil;
import com.heyux1n.shopping.mall.model.entity.system.SysOperateLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: heyux1n
 * @date: 2023/11/28 21:17
 * @description:
 * @version: 1.0.0
 */
@Aspect
@Component
public class LogAspect {

    @Autowired
    private AsyncOperateLogService asyncOperateLogService;

    @Around("@annotation(sysLog)")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint, Log sysLog) {
        Object proceed = null;
        SysOperateLog sysOperateLog = new SysOperateLog();
        try {
            LogUtil.beforeHandleLog(sysLog, joinPoint, sysOperateLog);
            proceed = joinPoint.proceed();
            LogUtil.afterHandlLog(sysLog, proceed, sysOperateLog, 0, null);
        } catch (Throwable e) {
            LogUtil.afterHandlLog(sysLog, proceed, sysOperateLog, 1, e.toString());
            throw new RuntimeException(e);
        }finally {
            asyncOperateLogService.saveSysOperateLog(sysOperateLog);
        }
        return proceed;
    }

}
