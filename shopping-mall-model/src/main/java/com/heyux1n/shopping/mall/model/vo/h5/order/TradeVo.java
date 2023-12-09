package com.heyux1n.shopping.mall.model.vo.h5.order;

import com.heyux1n.shopping.mall.model.entity.h5.order.OrderItem;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author: heyux1n
 * @date: 2023/12/9 19:56
 * @description:
 * @version: 1.0.0
 */
@Data
@Schema(description = "结算实体类")
public class TradeVo {

    @Schema(description = "结算总金额")
    private BigDecimal totalAmount;

    @Schema(description = "结算商品列表")
    private List<OrderItem> orderItemList;

}
