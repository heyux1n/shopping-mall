package com.heyux1n.shopping.mall.model.entity.h5;

import com.heyux1n.shopping.mall.model.entity.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: heyux1n
 * @date: 2023/12/9 18:12
 * @description:
 * @version: 1.0.0
 */
@Data
@Schema(description = "购物车实体类")
public class CartInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "用户id")
    private Long userId;

    @Schema(description = "skuId")
    private Long skuId;

    @Schema(description = "放入购物车时价格")
    private BigDecimal cartPrice;

    @Schema(description = "数量")
    private Integer skuNum;

    @Schema(description = "图片文件")
    private String imgUrl;

    @Schema(description = "sku名称 (冗余)")
    private String skuName;

    @Schema(description = "isChecked")
    private Integer isChecked;

}