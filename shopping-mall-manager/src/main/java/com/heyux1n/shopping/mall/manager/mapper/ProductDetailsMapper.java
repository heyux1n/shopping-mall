package com.heyux1n.shopping.mall.manager.mapper;

import com.heyux1n.shopping.mall.model.entity.product.ProductDetails;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: heyux1n
 * @date: 2023/11/26 18:12
 * @description:
 * @version: 1.0.0
 */
@Mapper
public interface ProductDetailsMapper {

    boolean save(ProductDetails productDetails);

    ProductDetails selectByProductId(Long productId);

    boolean updateById(ProductDetails productDetails);

    boolean deleteByProductId(Long productId);
}
