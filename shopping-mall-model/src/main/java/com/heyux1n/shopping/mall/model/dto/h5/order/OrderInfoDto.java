package com.heyux1n.shopping.mall.model.dto.h5.order;

import com.heyux1n.shopping.mall.model.entity.h5.order.OrderItem;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author: heyux1n
 * @date: 2023/12/10 17:40
 * @description: 订单信息dto
 * @version: 1.0.0
 */
@Data
@Schema(description = "订单信息dto")
public class OrderInfoDto {

    @Schema(description = "送货地址id")
    private Long userAddressId;

    @Schema(description = "运费")
    private BigDecimal feightFee;

    @Schema(description = "备注")
    private String remark;

    @Schema(description = "订单明细")
    private List<OrderItem> orderItemList;

}