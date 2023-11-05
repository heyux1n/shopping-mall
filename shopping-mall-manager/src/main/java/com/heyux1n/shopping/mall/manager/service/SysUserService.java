package com.heyux1n.shopping.mall.manager.service;

import com.github.pagehelper.PageInfo;
import com.heyux1n.shopping.mall.model.dto.system.AssignRoleDto;
import com.heyux1n.shopping.mall.model.dto.system.LoginDto;
import com.heyux1n.shopping.mall.model.dto.system.SysUserDto;
import com.heyux1n.shopping.mall.model.entity.system.SysUser;
import com.heyux1n.shopping.mall.model.vo.system.LoginVo;
import com.heyux1n.shopping.mall.model.vo.system.CaptchaVo;

public interface SysUserService {
    public CaptchaVo generateCaptcha();

    public LoginVo login(LoginDto loginDto);

    SysUser getUserInfo(String token);

    void logout(String token);

    PageInfo<SysUser> findByPage(SysUserDto sysUserDto, Integer pageNum, Integer pageSize);

    boolean saveSysUser(SysUser sysUser);

    boolean updateSysUser(SysUser sysUser);

    boolean deleteById(Long userId);

    boolean doAssign(AssignRoleDto assignRoleDto);
}
