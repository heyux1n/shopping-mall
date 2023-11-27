package com.heyux1n.shopping.mall.model.entity.product;

import com.heyux1n.shopping.mall.model.entity.base.BaseEntity;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: heyux1n
 * @date: 2023/11/27 21:01
 * @description: 订单统计信息
 * @version: 1.0.0
 */
@Data
public class OrderStatistics extends BaseEntity {

    /**
     * 统计日期
     */
    private Date orderDate;
    /**
     * 订单总金额
     */
    private BigDecimal totalAmount;
    /**
     * 订单量
     */
    private Integer totalNum;

}
