package com.heyux1n.shopping.mall.manager.service.impl;

import cn.hutool.core.date.DateUtil;
import com.heyux1n.shopping.mall.manager.mapper.OrderStatisticsMapper;
import com.heyux1n.shopping.mall.manager.service.OrderInfoService;
import com.heyux1n.shopping.mall.model.dto.product.OrderStatisticsDto;
import com.heyux1n.shopping.mall.model.entity.product.OrderStatistics;
import com.heyux1n.shopping.mall.model.vo.product.OrderStatisticsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author: heyux1n
 * @date: 2023/11/27 21:22
 * @description:
 * @version: 1.0.0
 */
@Service
public class OrderInfoServiceImpl implements OrderInfoService {
    @Autowired
    private OrderStatisticsMapper orderStatisticsMapper;

    @Override
    public OrderStatisticsVo getOrderStatisticsData(OrderStatisticsDto orderStatisticsDto) {
        List<OrderStatistics> orderStatisticsList = orderStatisticsMapper.selectListByTime(orderStatisticsDto);

        List<String> dateStrList = orderStatisticsList.stream().map(orderStatistics -> DateUtil.format(orderStatistics.getCreateTime(), "yyyy-MM-dd")).toList();
        List<BigDecimal> amountList = orderStatisticsList.stream().map(OrderStatistics::getTotalAmount).toList();

        OrderStatisticsVo orderStatisticsVo = new OrderStatisticsVo();
        orderStatisticsVo.setDateList(dateStrList);
        orderStatisticsVo.setAmountList(amountList);
        return orderStatisticsVo;
    }
}
