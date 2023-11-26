package com.heyux1n.shopping.mall.model.entity.product;

import com.heyux1n.shopping.mall.model.entity.base.BaseEntity;
import lombok.Data;

/**
 * @author: heyux1n
 * @date: 2023/11/26 17:36
 * @description:
 * @version: 1.0.0
 */
@Data
public class ProductDetails extends BaseEntity {

    private Long productId;
    private String imageUrls;

}