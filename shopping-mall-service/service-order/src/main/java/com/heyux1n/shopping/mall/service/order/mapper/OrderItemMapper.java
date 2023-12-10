package com.heyux1n.shopping.mall.service.order.mapper;

import com.heyux1n.shopping.mall.model.entity.h5.order.OrderItem;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: heyux1n
 * @date: 2023/12/10 17:46
 * @description:
 * @version: 1.0.0
 */
@Mapper
public interface OrderItemMapper {

    /**
     * 新增订单项
     * @param orderItem
     */
    void save(OrderItem orderItem);
}
