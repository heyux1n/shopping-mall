package com.heyux1n.shopping.mall.model.entity.product;

import com.heyux1n.shopping.mall.model.entity.base.BaseEntity;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: heyux1n
 * @date: 2023/11/26 17:35
 * @description:
 * @version: 1.0.0
 */
@Data
public class ProductSku extends BaseEntity {

    private String skuCode;
    private String skuName;
    private Long productId;
    private String thumbImg;
    private BigDecimal salePrice;
    private BigDecimal marketPrice;
    private BigDecimal costPrice;
    private Integer stockNum;
    private Integer saleNum;
    private String skuSpec;
    private String weight;
    private String volume;
    private Integer status;

}