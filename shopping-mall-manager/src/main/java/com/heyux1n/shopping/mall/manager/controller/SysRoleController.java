package com.heyux1n.shopping.mall.manager.controller;

import com.github.pagehelper.PageInfo;
import com.heyux1n.shopping.mall.manager.service.SysRoleService;
import com.heyux1n.shopping.mall.model.dto.system.SysRoleDto;
import com.heyux1n.shopping.mall.model.entity.system.SysRole;
import com.heyux1n.shopping.mall.model.vo.common.ListCheckResult;
import com.heyux1n.shopping.mall.model.vo.common.Result;
import com.heyux1n.shopping.mall.model.vo.common.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: heyux1n
 * @date: 2023/11/4 14:41
 * @description:
 * @version: 1.0.0
 */
@RestController
@RequestMapping(value = "/admin/system/sysRole")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService ;

    @GetMapping("/findByPage/{pageNum}/{pageSize}")
    public Result<PageInfo<SysRole>> findByPage(SysRoleDto sysRoleDto ,
                                                @PathVariable(value = "pageNum") Integer pageNum ,
                                                @PathVariable(value = "pageSize") Integer pageSize) {
        PageInfo<SysRole> pageInfo = sysRoleService.findByPage(sysRoleDto , pageNum , pageSize);
        return Result.build(pageInfo , ResultCodeEnum.SUCCESS);
    }


    @PostMapping(value = "/saveSysRole")
    public Result saveSysRole(@RequestBody SysRole SysRole) {
        boolean b = sysRoleService.saveSysRole(SysRole);
        return Result.build(b , ResultCodeEnum.SUCCESS);
    }

    @PutMapping(value = "/updateSysRole")
    public Result updateSysRole(@RequestBody SysRole sysRole) {
        boolean b = sysRoleService.updateSysRole(sysRole);
        return Result.build(b , ResultCodeEnum.SUCCESS);
    }


    @DeleteMapping(value = "/deleteById/{roleId}")
    public Result deleteById(@PathVariable(value = "roleId") Long roleId) {
        boolean b = sysRoleService.deleteById(roleId);
        return Result.build(b , ResultCodeEnum.SUCCESS);
    }

    @GetMapping(value = "/findAllRoles/{userId}")
    public Result findAllRoles(@PathVariable(value = "userId") Long userId) {
        ListCheckResult<SysRole> listCheckResult = sysRoleService.findAllRoles(userId);
        return Result.build(listCheckResult , ResultCodeEnum.SUCCESS)  ;
    }

}