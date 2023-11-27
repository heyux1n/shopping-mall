package com.heyux1n.shopping.mall.manager.mapper;

import com.heyux1n.shopping.mall.model.entity.product.OrderStatistics;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: heyux1n
 * @date: 2023/11/27 21:07
 * @description:
 * @version: 1.0.0
 */
@Mapper
public interface OrderInfoMapper {
    OrderStatistics selectOrderStatistics(String createTime);
}
