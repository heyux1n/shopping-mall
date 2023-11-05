package com.heyux1n.shopping.mall.manager.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: heyux1n
 * @date: 2023/11/5 16:47
 * @description:
 * @version: 1.0.0
 */
@Mapper
public interface SysUserRoleMapper {
    public abstract List<Long> findRoleIdsByUserId(Long userId);

    public abstract void doAssign(Long userId, Long roleId);

    public abstract void deleteByUserId(Long userId);
}
