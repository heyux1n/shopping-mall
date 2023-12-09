package com.heyux1n.shopping.mall.service.user.service.impl;

import com.heyux1n.shopping.mall.common.service.util.AuthContextUtil;
import com.heyux1n.shopping.mall.model.entity.h5.UserAddress;
import com.heyux1n.shopping.mall.model.entity.h5.UserInfo;
import com.heyux1n.shopping.mall.service.user.mapper.UserAddressMapper;
import com.heyux1n.shopping.mall.service.user.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: heyux1n
 * @date: 2023/12/9 19:27
 * @description:
 * @version: 1.0.0
 */
@Service
public class UserAddressServiceImpl implements UserAddressService {

    @Autowired
    private UserAddressMapper userAddressMapper;

    @Override
    public List<UserAddress> findUserAddressList() {
        UserInfo userInfo = AuthContextUtil.getUserInfo();
        return userAddressMapper.findAllByUserId(userInfo.getId());
    }
}
