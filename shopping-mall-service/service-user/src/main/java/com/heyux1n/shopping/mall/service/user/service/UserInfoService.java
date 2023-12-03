package com.heyux1n.shopping.mall.service.user.service;

import com.heyux1n.shopping.mall.model.dto.h5.UserLoginDto;
import com.heyux1n.shopping.mall.model.dto.h5.UserRegisterDto;
import com.heyux1n.shopping.mall.model.vo.h5.UserInfoVo;

/**
 * @author: heyux1n
 * @date: 2023/12/3 17:36
 * @description:
 * @version: 1.0.0
 */
public interface UserInfoService {
    /**
     * 用户注册
     * @param userRegisterDto
     */
    void register(UserRegisterDto userRegisterDto);

    /**
     * 用户登录
     * @param userLoginDto
     * @return
     */
    String login(UserLoginDto userLoginDto);

    /**
     * 获取用户详情
     * @param token
     * @return
     */
    UserInfoVo getCurrentUserInfo(String token);
}
