package com.heyux1n.shopping.mall.service.order.mapper;

import com.heyux1n.shopping.mall.model.entity.h5.order.OrderLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: heyux1n
 * @date: 2023/12/10 17:47
 * @description:
 * @version: 1.0.0
 */
@Mapper
public interface OrderLogMapper {

    /**
     * 新增订单日志
     * @param orderLog
     */
    void save(OrderLog orderLog);
}
