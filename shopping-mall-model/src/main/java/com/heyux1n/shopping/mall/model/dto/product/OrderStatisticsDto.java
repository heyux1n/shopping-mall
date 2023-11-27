package com.heyux1n.shopping.mall.model.dto.product;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author: heyux1n
 * @date: 2023/11/27 21:18
 * @description:
 * @version: 1.0.0
 */
@Schema(description = "订单统计查询")
@Data
public class OrderStatisticsDto {

    @Schema(description = "开始时间")
    private String createTimeBegin;
    @Schema(description = "结束时间")
    private String createTimeEnd;

}