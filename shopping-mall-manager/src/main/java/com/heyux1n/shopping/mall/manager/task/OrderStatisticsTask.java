package com.heyux1n.shopping.mall.manager.task;

import cn.hutool.core.date.DateUtil;
import com.heyux1n.shopping.mall.manager.mapper.OrderInfoMapper;
import com.heyux1n.shopping.mall.manager.mapper.OrderStatisticsMapper;
import com.heyux1n.shopping.mall.model.entity.product.OrderStatistics;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: heyux1n
 * @date: 2023/11/27 21:05
 * @description:
 * @version: 1.0.0
 */
@Component
@Slf4j
public class OrderStatisticsTask {

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Autowired
    private OrderStatisticsMapper orderStatisticsMapper;

    /**
     * 每天2点执行
     */
    @Scheduled(cron = "0 0 2 * * ?")
    public void orderTotalAmountStatistics() {
        String createTime = DateUtil.offsetDay(new Date(), -1).toString(new SimpleDateFormat("yyyy-MM-dd"));
        //查询当天订单统计数据
        OrderStatistics orderStatistics = orderInfoMapper.selectOrderStatistics(createTime);
        if(orderStatistics != null) {
            //保存统计数据
            orderStatisticsMapper.insert(orderStatistics);
        }
    }

}