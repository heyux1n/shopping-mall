package com.heyux1n.shopping.mall.manager.controller;

import com.github.pagehelper.PageInfo;
import com.heyux1n.shopping.mall.common.log.annotation.Log;
import com.heyux1n.shopping.mall.common.log.enums.OperatorType;
import com.heyux1n.shopping.mall.manager.service.SysUserService;
import com.heyux1n.shopping.mall.model.dto.system.AssignRoleDto;
import com.heyux1n.shopping.mall.model.dto.system.SysUserDto;
import com.heyux1n.shopping.mall.model.entity.system.SysRole;
import com.heyux1n.shopping.mall.model.entity.system.SysUser;
import com.heyux1n.shopping.mall.model.vo.common.Result;
import com.heyux1n.shopping.mall.model.vo.common.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: heyux1n
 * @date: 2023/11/4 21:43
 * @description:
 * @version: 1.0.0
 */
@RestController
@RequestMapping(value = "/admin/system/sysUser")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping(value = "/findByPage/{pageNum}/{pageSize}")
    public Result<PageInfo<SysRole>> findByPage(SysUserDto sysUserDto,
                                                @PathVariable(value = "pageNum") Integer pageNum,
                                                @PathVariable(value = "pageSize") Integer pageSize) {
        PageInfo<SysUser> pageInfo = sysUserService.findByPage(sysUserDto, pageNum, pageSize);
        return Result.build(pageInfo, ResultCodeEnum.SUCCESS);
    }


    @Log(title = "用户管理:新增", businessType = 1, operatorType = OperatorType.MANAGE)
    @PostMapping(value = "/saveSysUser")
    public Result saveSysUser(@RequestBody SysUser sysUser) {
        return Result.build(sysUserService.saveSysUser(sysUser), ResultCodeEnum.SUCCESS);
    }


    @Log(title = "用户管理:修改", businessType = 2, operatorType = OperatorType.MANAGE)
    @PutMapping(value = "/updateSysUser")
    public Result updateSysUser(@RequestBody SysUser sysUser) {
        return Result.build(sysUserService.updateSysUser(sysUser), ResultCodeEnum.SUCCESS);
    }

    @Log(title = "用户管理:删除", businessType = 3, operatorType = OperatorType.MANAGE)
    @DeleteMapping(value = "/deleteById/{userId}")
    public Result deleteById(@PathVariable(value = "userId") Long userId) {
        return Result.build(sysUserService.deleteById(userId), ResultCodeEnum.SUCCESS);
    }

    @Log(title = "用户管理:设置角色", businessType = 4, operatorType = OperatorType.MANAGE)
    @PostMapping("/doAssign")
    public Result doAssign(@RequestBody AssignRoleDto assignRoleDto) {
        return Result.build(sysUserService.doAssign(assignRoleDto) , ResultCodeEnum.SUCCESS) ;
    }
}