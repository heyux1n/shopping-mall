package com.heyux1n.shopping.mall.service.user.mapper;

import com.heyux1n.shopping.mall.model.entity.h5.UserAddress;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: heyux1n
 * @date: 2023/12/9 19:28
 * @description:
 * @version: 1.0.0
 */
@Mapper
public interface UserAddressMapper {
    /**
     * 根据用户查询全部
     * @param id
     * @return
     */
    List<UserAddress> findAllByUserId(Long id);

    /**
     * 根据地址id查询地址
     * @param id
     * @return
     */
    UserAddress getById(Long id);
}
