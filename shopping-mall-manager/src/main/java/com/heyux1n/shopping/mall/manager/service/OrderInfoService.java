package com.heyux1n.shopping.mall.manager.service;

import com.heyux1n.shopping.mall.model.dto.product.OrderStatisticsDto;
import com.heyux1n.shopping.mall.model.vo.product.OrderStatisticsVo;

/**
 * @author: heyux1n
 * @date: 2023/11/27 21:22
 * @description:
 * @version: 1.0.0
 */
public interface OrderInfoService {
    /**
     * 获取订单统计信息
     * @param orderStatisticsDto
     * @return
     */
    OrderStatisticsVo getOrderStatisticsData(OrderStatisticsDto orderStatisticsDto);
}
