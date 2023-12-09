package com.heyux1n.shopping.mall.service.user.service;

import com.heyux1n.shopping.mall.model.entity.h5.UserAddress;

import java.util.List;

/**
 * @author: heyux1n
 * @date: 2023/12/9 19:27
 * @description:
 * @version: 1.0.0
 */
public interface UserAddressService {
    /**
     * 查询用户地址
     * @return
     */
    List<UserAddress> findUserAddressList();
}
