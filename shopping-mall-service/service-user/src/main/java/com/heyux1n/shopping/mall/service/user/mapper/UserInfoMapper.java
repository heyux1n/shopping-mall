package com.heyux1n.shopping.mall.service.user.mapper;

import com.heyux1n.shopping.mall.model.entity.h5.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: heyux1n
 * @date: 2023/12/3 17:39
 * @description:
 * @version: 1.0.0
 */
@Mapper
public interface UserInfoMapper {
    /**
     * 查询用户
     * @param username
     * @return
     */
    UserInfo getByUsername(String username);

    /**
     * 新增用户
     * @param userInfo
     */
    void save(UserInfo userInfo);
}
