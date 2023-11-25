package com.heyux1n.shopping.mall.model.entity.product;

import com.heyux1n.shopping.mall.model.entity.base.BaseEntity;
import lombok.Data;

/**
 * @author: heyux1n
 * @date: 2023/11/25 16:55
 * @description:
 * @version: 1.0.0
 */
@Data
public class CategoryBrand extends BaseEntity {

    private Long brandId;
    private Long categoryId;

    /**
     * 联查分裂名称
     */
    private String categoryName;
    private String brandName;
    private String logo;

}