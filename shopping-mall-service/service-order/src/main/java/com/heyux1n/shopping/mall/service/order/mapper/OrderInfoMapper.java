package com.heyux1n.shopping.mall.service.order.mapper;

import com.heyux1n.shopping.mall.model.entity.product.OrderInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

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

    /**
     * 根据id查询订单信息
     * @param id
     * @return
     */
    OrderInfo getById(Long id);

    /**
     * 分页查询订单数据
     * @param userId
     * @param orderStatus
     * @return
     */
    List<OrderInfo> findUserPage(Long userId, Integer orderStatus);

    /**
     * 根据订单编号查询
     * @param orderNo
     * @return
     */
    OrderInfo getByOrderNo(String orderNo);

    /**
     * 更新订单信息
     * @param orderInfo
     */
    void updateById(OrderInfo orderInfo);
}