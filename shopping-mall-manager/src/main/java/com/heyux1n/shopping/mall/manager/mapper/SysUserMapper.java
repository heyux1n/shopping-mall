package com.heyux1n.shopping.mall.manager.mapper;

import com.heyux1n.shopping.mall.model.dto.system.SysUserDto;
import com.heyux1n.shopping.mall.model.entity.system.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysUserMapper {
    /**
     * 根据用户名查询用户数据
     * @param userName
     * @return
     */
    public abstract SysUser selectByUserName(String userName);

    /**
     * 分页查新用户列表
     * @param sysUserDto
     * @return
     */
    public abstract List<SysUser> findByPage(SysUserDto sysUserDto);


    public abstract boolean saveSysUser(SysUser sysUser);

    public abstract boolean updateSysUser(SysUser sysUser);

    public abstract boolean deleteById(Long id);
}
