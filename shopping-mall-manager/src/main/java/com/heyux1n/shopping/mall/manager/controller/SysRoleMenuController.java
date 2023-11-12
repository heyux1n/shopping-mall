package com.heyux1n.shopping.mall.manager.controller;

import com.heyux1n.shopping.mall.manager.service.SysRoleMenuService;
import com.heyux1n.shopping.mall.model.dto.system.AssignMenuDto;
import com.heyux1n.shopping.mall.model.entity.system.SysMenu;
import com.heyux1n.shopping.mall.model.vo.common.ListCheckResult;
import com.heyux1n.shopping.mall.model.vo.common.Result;
import com.heyux1n.shopping.mall.model.vo.common.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author: heyux1n
 * @date: 2023/11/9 22:00
 * @description:
 * @version: 1.0.0
 */
@RestController
@RequestMapping(value = "/admin/system/sysRoleMenu")
public class SysRoleMenuController {

    @Autowired
    private SysRoleMenuService sysRoleMenuService ;

    @GetMapping(value = "/findSysRoleMenuByRoleId/{roleId}")
    public Result<ListCheckResult<SysMenu>> findSysRoleMenuByRoleId(@PathVariable(value = "roleId") Long roleId) {
        ListCheckResult<SysMenu> listCheckResult = sysRoleMenuService.findSysRoleMenuByRoleId(roleId);
        return Result.build(listCheckResult , ResultCodeEnum.SUCCESS) ;
    }

    @PostMapping("/doAssign")
    public Result doAssign(@RequestBody AssignMenuDto assignMenuDto) {
        return Result.build(sysRoleMenuService.doAssign(assignMenuDto) , ResultCodeEnum.SUCCESS) ;
    }

}