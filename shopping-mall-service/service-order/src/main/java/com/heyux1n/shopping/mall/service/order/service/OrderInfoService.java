package com.heyux1n.shopping.mall.service.order.service;

import com.github.pagehelper.PageInfo;
import com.heyux1n.shopping.mall.model.dto.h5.order.OrderInfoDto;
import com.heyux1n.shopping.mall.model.entity.product.OrderInfo;
import com.heyux1n.shopping.mall.model.vo.h5.order.TradeVo;

/**
 * @author: heyux1n
 * @date: 2023/12/9 19:58
 * @description:
 * @version: 1.0.0
 */
public interface OrderInfoService {
    /**
     * 获取结算数据
     * @return
     */
    TradeVo getTrade();

    /**
     * 提交订单
     * @param orderInfoDto
     * @return
     */
    Long submitOrder(OrderInfoDto orderInfoDto);

    /**
     * 查询订单信息
     * @param orderId
     * @return
     */
    OrderInfo getOrderInfo(Long orderId);

    /**
     * 立即购买获取结算数据
     * @param skuId
     * @return
     */
    TradeVo buy(Long skuId);

    /**
     * 分页获取用户订单信息
     * @param page
     * @param limit
     * @param orderStatus
     * @return
     */
    PageInfo<OrderInfo> findUserPage(Integer page, Integer limit, Integer orderStatus);

    /**
     * 根据订单编号获取订单编号
     * @param orderNo
     * @return
     */
    OrderInfo getByOrderNo(String orderNo);

    /**
     * 更新订单状态
     * @param orderNo
     * @param payType
     */
    void updateOrderStatus(String orderNo, Integer payType);
}
