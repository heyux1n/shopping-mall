package com.heyux1n.shopping.mall.manager.service.impl;

import com.heyux1n.shopping.mall.common.log.service.AsyncOperateLogService;
import com.heyux1n.shopping.mall.manager.mapper.SysOperateLogMapper;
import com.heyux1n.shopping.mall.model.entity.system.SysOperateLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: heyux1n
 * @date: 2023/11/28 21:45
 * @description:
 * @version: 1.0.0
 */
@Service
public class AsyncOperateLogServiceImpl implements AsyncOperateLogService {

    @Autowired
    private SysOperateLogMapper sysOperateLogMapper;

    @Override
    public void saveSysOperateLog(SysOperateLog sysOperateLog) {
        sysOperateLogMapper.save(sysOperateLog);
    }
}
