package com.heyux1n.shopping.mall.model.dto.product;

import com.heyux1n.shopping.mall.model.entity.base.BaseEntity;
import lombok.Data;

/**
 * @author: heyux1n
 * @date: 2023/11/26 17:34
 * @description:
 * @version: 1.0.0
 */
@Data
public class ProductDto extends BaseEntity {

    private Long brandId;
    private Long category1Id;
    private Long category2Id;
    private Long category3Id;

}
