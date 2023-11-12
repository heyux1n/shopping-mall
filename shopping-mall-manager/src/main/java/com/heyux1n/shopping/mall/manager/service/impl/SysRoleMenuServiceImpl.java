package com.heyux1n.shopping.mall.manager.service.impl;

import com.heyux1n.shopping.mall.manager.helper.MenuHelper;
import com.heyux1n.shopping.mall.manager.mapper.SysMenuMapper;
import com.heyux1n.shopping.mall.manager.mapper.SysRoleMenuMapper;
import com.heyux1n.shopping.mall.manager.service.SysRoleMenuService;
import com.heyux1n.shopping.mall.model.dto.system.AssignMenuDto;
import com.heyux1n.shopping.mall.model.entity.system.SysMenu;
import com.heyux1n.shopping.mall.model.vo.common.ListCheckResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author: heyux1n
 * @date: 2023/11/9 21:56
 * @description:
 * @version: 1.0.0
 */
@Service
public class SysRoleMenuServiceImpl implements SysRoleMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;
    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Override
    public ListCheckResult findSysRoleMenuByRoleId(Long roleId) {
        List<SysMenu> menuList = sysMenuMapper.findAll();
        List<SysMenu> menusTree = MenuHelper.buildTree(menuList);
        List<Long> checkedMenuId = sysRoleMenuMapper.findSysRoleMenuByRoleId(roleId);
        ListCheckResult<SysMenu> checkResult = new ListCheckResult<>();
        checkResult.setAllList(menusTree);
        checkResult.setCheckIdList(checkedMenuId);
        return checkResult;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean doAssign(AssignMenuDto assignMenuDto) {
        sysRoleMenuMapper.deleteByRoleId(assignMenuDto.getRoleId());
        sysRoleMenuMapper.doAssign(assignMenuDto);
        return true;
    }
}
