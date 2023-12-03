package com.heyux1n.shopping.mall.service.user.service.impl;

import com.heyux1n.shopping.mall.common.exception.ServiceResException;
import com.heyux1n.shopping.mall.model.dto.h5.UserRegisterDto;
import com.heyux1n.shopping.mall.model.entity.h5.UserInfo;
import com.heyux1n.shopping.mall.model.vo.common.ResultCodeEnum;
import com.heyux1n.shopping.mall.service.user.mapper.UserInfoMapper;
import com.heyux1n.shopping.mall.service.user.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

/**
 * @author: heyux1n
 * @date: 2023/12/3 17:37
 * @description:
 * @version: 1.0.0
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    @Override
    public void register(UserRegisterDto userRegisterDto) {
        // 获取数据
        String username = userRegisterDto.getUsername();
        String password = userRegisterDto.getPassword();
        String nickName = userRegisterDto.getNickName();
        String code = userRegisterDto.getCode();

        //校验参数
        if(StringUtils.isEmpty(username) ||
                StringUtils.isEmpty(password) ||
                StringUtils.isEmpty(nickName) ||
                StringUtils.isEmpty(code)) {
            throw new ServiceResException(ResultCodeEnum.DATA_ERROR);
        }
        //1.校验验证码，手机号就是用户名
        String codeValueRedis = redisTemplate.opsForValue().get("phone:code:" + username);
        if(!code.equals(codeValueRedis)) {
            throw new ServiceResException(ResultCodeEnum.CAPTCHA_ERROR);
        }


        //2.校验用户是否已经存在
        UserInfo userInfo = userInfoMapper.getByUsername(username);
        if(null != userInfo) {
            throw new ServiceResException(ResultCodeEnum.USER_NAME_IS_EXISTS);
        }

        //3.新增用户
        String userDefaultAvatar = "http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132";
        userInfo = new UserInfo();
        userInfo.setUsername(username);
        userInfo.setNickName(nickName);
        userInfo.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
        userInfo.setPhone(username);
        userInfo.setStatus(1);
        userInfo.setSex(0);
        userInfo.setAvatar(userDefaultAvatar);
        userInfoMapper.save(userInfo);
    }
}
