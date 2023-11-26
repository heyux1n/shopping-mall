package com.heyux1n.shopping.mall.manager.mapper;

import com.heyux1n.shopping.mall.model.entity.product.ProductSku;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: heyux1n
 * @date: 2023/11/26 18:10
 * @description:
 * @version: 1.0.0
 */
@Mapper
public interface ProductSkuMapper {

    boolean save(ProductSku productSku);

    List<ProductSku> selectByProductId(Long productId);

    boolean updateById(ProductSku productSku);

    boolean deleteByProductId(Long productId);
}
