package com.heyux1n.shopping.mall.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.heyux1n.shopping.mall.manager.mapper.SysRoleMapper;
import com.heyux1n.shopping.mall.manager.mapper.SysUserRoleMapper;
import com.heyux1n.shopping.mall.manager.service.SysRoleService;
import com.heyux1n.shopping.mall.model.dto.system.SysRoleDto;
import com.heyux1n.shopping.mall.model.entity.system.SysRole;
import com.heyux1n.shopping.mall.model.vo.common.ListCheckResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: heyux1n
 * @date: 2023/11/4 14:42
 * @description:
 * @version: 1.0.0
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;


    @Override
    public PageInfo<SysRole> findByPage(SysRoleDto sysRoleDto, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<SysRole> sysRoleList = sysRoleMapper.findByPage(sysRoleDto);
        PageInfo<SysRole> sysRolePageInfo = new PageInfo(sysRoleList);
        return sysRolePageInfo;
    }

    @Override
    public boolean saveSysRole(SysRole sysRole) {
        return sysRoleMapper.saveSysRole(sysRole);
    }

    @Override
    public boolean updateSysRole(SysRole sysRole) {
        return sysRoleMapper.updateSysRole(sysRole);
    }

    @Override
    public boolean deleteById(Long roleId) {
        return sysRoleMapper.deleteById(roleId);
    }

    @Override
    public ListCheckResult<SysRole> findAllRoles(Long userId) {
        List<SysRole> allRoles = sysRoleMapper.findAllRoles();
        List<Long> roleIds = sysUserRoleMapper.findRoleIdsByUserId(userId);
        ListCheckResult<SysRole> listCheckResult = new ListCheckResult<>();
        listCheckResult.setAllList(allRoles);
        listCheckResult.setCheckIdList(roleIds);
        return listCheckResult;
    }
}
