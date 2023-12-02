package com.heyux1n.shopping.mall.service.product.mapper;

import com.heyux1n.shopping.mall.model.entity.product.ProductDetails;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: heyux1n
 * @date: 2023/12/2 21:42
 * @description:
 * @version: 1.0.0
 */
@Mapper
public interface ProductDetailsMapper {
    /**
     * 根据productId查询详情
     * @param productId
     * @return
     */
    ProductDetails getByProductId(Long productId);
}
