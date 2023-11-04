package com.heyux1n.shopping.mall.manager.controller;

import com.heyux1n.shopping.mall.model.entity.system.SysUser;
import com.heyux1n.shopping.mall.model.vo.common.Result;
import com.heyux1n.shopping.mall.model.vo.common.ResultCodeEnum;
import com.heyux1n.shopping.mall.model.dto.system.LoginDto;
import com.heyux1n.shopping.mall.manager.service.SysUserService;
import com.heyux1n.shopping.mall.model.vo.system.CaptchaVo;
import com.heyux1n.shopping.mall.model.vo.system.LoginVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

@Tag(name = "用户接口")
@RestController
@RequestMapping(value = "/admin/system/index")
public class IndexController {

    @Autowired
    private SysUserService sysUserService ;

    @Operation(summary = "获取验证码")
    @GetMapping(value = "/generateCaptcha")
    public Result<LoginVo> generateCaptcha() {
        CaptchaVo captchaVo = sysUserService.generateCaptcha();
        return Result.build(captchaVo , ResultCodeEnum.SUCCESS) ;
    }


    @Operation(summary = "登录接口")
    @PostMapping(value = "/login")
    public Result<LoginVo> login(@RequestBody LoginDto loginDto) {
        LoginVo loginVo = sysUserService.login(loginDto) ;
        return Result.build(loginVo , ResultCodeEnum.SUCCESS) ;
    }

    @GetMapping(value = "/getUserInfo")
    public Result<SysUser> getUserInfo(@RequestHeader(name = HttpHeaders.AUTHORIZATION) String token) {
        SysUser sysUser = sysUserService.getUserInfo(token) ;
        return Result.build(sysUser , ResultCodeEnum.SUCCESS) ;
    }


    @GetMapping(value = "/logout")
    public Result logout(@RequestHeader(value = HttpHeaders.AUTHORIZATION) String token) {
        sysUserService.logout(token);
        return Result.build(ResultCodeEnum.SUCCESS) ;
    }
}