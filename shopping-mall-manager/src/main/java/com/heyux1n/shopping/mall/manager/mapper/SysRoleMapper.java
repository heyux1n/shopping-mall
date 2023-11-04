package com.heyux1n.shopping.mall.manager.mapper;

import com.heyux1n.shopping.mall.model.dto.system.SysRoleDto;
import com.heyux1n.shopping.mall.model.entity.system.SysRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: heyux1n
 * @date: 2023/11/4 14:43
 * @description:
 * @version: 1.0.0
 */
@Mapper
public interface SysRoleMapper {
    public abstract List<SysRole> findByPage(SysRoleDto sysRoleDto);

    public abstract boolean saveSysRole(SysRole sysRole);

    public abstract boolean updateSysRole(SysRole sysRole);

    public abstract boolean deleteById(Long roleId);
}
