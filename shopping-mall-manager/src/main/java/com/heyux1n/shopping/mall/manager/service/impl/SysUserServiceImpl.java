package com.heyux1n.shopping.mall.manager.service.impl;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import cn.hutool.crypto.digest.DigestUtil;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.heyux1n.shopping.mall.common.exception.ServiceResException;
import com.heyux1n.shopping.mall.common.util.AuthContextUtil;
import com.heyux1n.shopping.mall.manager.mapper.SysUserMapper;
import com.heyux1n.shopping.mall.manager.mapper.SysUserRoleMapper;
import com.heyux1n.shopping.mall.model.dto.system.AssignRoleDto;
import com.heyux1n.shopping.mall.model.dto.system.LoginDto;
import com.heyux1n.shopping.mall.manager.service.SysUserService;
import com.heyux1n.shopping.mall.model.dto.system.SysUserDto;
import com.heyux1n.shopping.mall.model.entity.system.SysUser;
import com.heyux1n.shopping.mall.model.vo.system.LoginVo;
import com.heyux1n.shopping.mall.model.vo.common.ResultCodeEnum;
import com.heyux1n.shopping.mall.model.vo.system.CaptchaVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class SysUserServiceImpl implements SysUserService {


    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    @Override
    public CaptchaVo generateCaptcha() {
        //1.生成唯一key、随机验证码及验证码base64值
        String key = UUID.randomUUID().toString().replaceAll("-", "");
        CircleCaptcha circleCaptcha = CaptchaUtil.createCircleCaptcha(150, 48, 4, 10);

        //2.redis存储key-captcha值映射
        redisTemplate.opsForValue().set("user:login:captcha:" + key, circleCaptcha.getCode(), 5, TimeUnit.MINUTES);

        CaptchaVo captchaVo = new CaptchaVo();
        captchaVo.setCodeKey(key);
        //拼接base64格式
        captchaVo.setCodeValue("data:image/png;base64," + circleCaptcha.getImageBase64());
        return captchaVo;
    }

    @Override
    public LoginVo login(LoginDto loginDto) {
        //0.校验验证码
        //"user:login:captcha:" + key
        String captchaKey = "user:login:captcha:" + loginDto.getCodeKey();
        String captcha = redisTemplate.opsForValue().get(captchaKey);
        if (StringUtil.isEmpty(captcha) || !captcha.equalsIgnoreCase(loginDto.getCaptcha())) {
            throw new ServiceResException(ResultCodeEnum.CAPTCHA_ERROR);
        }
        //删除验证码
        redisTemplate.delete(captchaKey);

        //1.查询用户是否存在
        SysUser sysUser = sysUserMapper.selectByUserName(loginDto.getUserName());

        //2.不存在抛出用户不存在异常
        if (sysUser == null) {
            throw new ServiceResException(ResultCodeEnum.USER_UNREGISTERED);
        }

        //3.存在则将传入的password进行md5加密后与数据库中已加密的密码进行对比
        String digestPassword = DigestUtil.md5Hex(loginDto.getPassword());

        //4.密码不一致则抛出密码错误的异常
        if (!digestPassword.equals(sysUser.getPassword())) {
            throw new ServiceResException(ResultCodeEnum.LOGIN_ERROR);
        }

        //5.密码一致则创建token存储redis，并返回登录成功的响应
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        redisTemplate.opsForValue().set("user:login:" + token, JSON.toJSONString(sysUser), 10, TimeUnit.MINUTES);

        LoginVo loginVo = new LoginVo();
        loginVo.setToken(token);
        return loginVo;
    }

    @Override
    public SysUser getUserInfo(String token) {
        return AuthContextUtil.get();
    }

    @Override
    public void logout(String token) {
        redisTemplate.delete("user:login:" + token);
    }

    @Override
    public PageInfo<SysUser> findByPage(SysUserDto sysUserDto, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<SysUser> sysUserList = sysUserMapper.findByPage(sysUserDto);
        return new PageInfo<>(sysUserList);
    }

    @Override
    public boolean saveSysUser(SysUser sysUser) {
        return sysUserMapper.saveSysUser(sysUser);
    }

    @Override
    public boolean updateSysUser(SysUser sysUser) {
        return sysUserMapper.updateSysUser(sysUser);
    }

    @Override
    public boolean deleteById(Long userId) {
        return sysUserMapper.deleteById(userId);
    }

    @Override
    @Transactional
    public boolean doAssign(AssignRoleDto assignRoleDto) {
        sysUserRoleMapper.deleteByUserId(assignRoleDto.getUserId());
        assignRoleDto.getRoleIdList().forEach(roleId -> {
            sysUserRoleMapper.doAssign(assignRoleDto.getUserId(), roleId);
        });
        return true;
    }


}
