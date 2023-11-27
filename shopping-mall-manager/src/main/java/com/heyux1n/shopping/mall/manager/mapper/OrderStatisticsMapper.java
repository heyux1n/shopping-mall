package com.heyux1n.shopping.mall.manager.mapper;

import com.heyux1n.shopping.mall.model.dto.product.OrderStatisticsDto;
import com.heyux1n.shopping.mall.model.entity.product.OrderStatistics;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: heyux1n
 * @date: 2023/11/27 21:07
 * @description:
 * @version: 1.0.0
 */
@Mapper
public interface OrderStatisticsMapper {


        boolean insert(OrderStatistics orderStatistics);

        List<OrderStatistics> selectListByTime(OrderStatisticsDto orderStatisticsDto);
}
