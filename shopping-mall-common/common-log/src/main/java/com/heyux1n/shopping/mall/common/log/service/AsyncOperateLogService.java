package com.heyux1n.shopping.mall.common.log.service;

import com.heyux1n.shopping.mall.model.entity.system.SysOperateLog;

/**
 * @author: heyux1n
 * @date: 2023/11/28 21:37
 * @description:
 * @version: 1.0.0
 */
public interface AsyncOperateLogService {
    /**
     * 保存系统日志
     * @param sysOperateLog
     */
    public abstract void saveSysOperateLog(SysOperateLog sysOperateLog);
}
