package com.heyux1n.shopping.mall.manager.mapper;

import com.heyux1n.shopping.mall.model.entity.system.SysOperateLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: heyux1n
 * @date: 2023/11/28 21:46
 * @description:
 * @version: 1.0.0
 */
@Mapper
public interface SysOperateLogMapper {
    /**
     * 保存日志
     * @param sysOperateLog
     */
    void save(SysOperateLog sysOperateLog);
}
