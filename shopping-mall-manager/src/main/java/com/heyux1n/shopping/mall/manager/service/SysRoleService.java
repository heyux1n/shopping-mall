package com.heyux1n.shopping.mall.manager.service;

import com.github.pagehelper.PageInfo;
import com.heyux1n.shopping.mall.model.dto.system.SysRoleDto;
import com.heyux1n.shopping.mall.model.entity.system.SysRole;
import com.heyux1n.shopping.mall.model.vo.common.ListCheckResult;

/**
 * @author: heyux1n
 * @date: 2023/11/4 14:42
 * @description:
 * @version: 1.0.0
 */
public interface SysRoleService {
    PageInfo<SysRole> findByPage(SysRoleDto sysRoleDto, Integer pageNum, Integer pageSize);

    boolean saveSysRole(SysRole sysRole);

    boolean updateSysRole(SysRole sysRole);

    boolean deleteById(Long roleId);

    ListCheckResult<SysRole> findAllRoles(Long userId);

}
