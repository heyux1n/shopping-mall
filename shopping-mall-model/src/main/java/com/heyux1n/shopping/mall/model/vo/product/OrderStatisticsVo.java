package com.heyux1n.shopping.mall.model.vo.product;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author: heyux1n
 * @date: 2023/11/27 21:19
 * @description:
 * @version: 1.0.0
 */
@Schema(description = "订单统计信息展示")
@Data
public class OrderStatisticsVo {

    @Schema(description = "日期列表")
    private List<String> dateList;

    @Schema(description = "订单金额列表")
    private List<BigDecimal> amountList;
}
