package com.heyux1n.shopping.mall.manager.mapper;

import com.heyux1n.shopping.mall.model.entity.product.ProductSpec;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: heyux1n
 * @date: 2023/11/26 16:42
 * @description:
 * @version: 1.0.0
 */
@Mapper
public interface ProductSpecMapper {
    List<ProductSpec> selectAll();

    boolean save(ProductSpec productSpec);

    boolean updateById(ProductSpec productSpec);

    boolean deleteById(Long id);
}
