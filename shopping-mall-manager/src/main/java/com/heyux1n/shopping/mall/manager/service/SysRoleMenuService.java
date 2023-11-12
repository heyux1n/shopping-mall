package com.heyux1n.shopping.mall.manager.service;

import com.heyux1n.shopping.mall.model.dto.system.AssignMenuDto;
import com.heyux1n.shopping.mall.model.vo.common.ListCheckResult;

import java.util.Map;

/**
 * @author: heyux1n
 * @date: 2023/11/9 21:56
 * @description:
 * @version: 1.0.0
 */
public interface SysRoleMenuService {
    ListCheckResult findSysRoleMenuByRoleId(Long roleId);

    boolean doAssign(AssignMenuDto assignMenuDto);
}
