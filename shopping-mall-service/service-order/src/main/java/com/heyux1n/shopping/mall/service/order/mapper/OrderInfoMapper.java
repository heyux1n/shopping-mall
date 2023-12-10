package com.heyux1n.shopping.mall.service.order.mapper;

import com.heyux1n.shopping.mall.model.entity.product.OrderInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: heyux1n
 * @date: 2023/12/10 17:46
 * @description:
 * @version: 1.0.0
 */
@Mapper
public interface OrderInfoMapper {

    /**
     * 新增订单信息
     * @param orderInfo
     */
    void save(OrderInfo orderInfo);
}