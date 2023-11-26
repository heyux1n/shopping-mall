package com.heyux1n.shopping.mall.manager.mapper;

import com.heyux1n.shopping.mall.model.entity.product.ProductUnit;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: heyux1n
 * @date: 2023/11/26 17:49
 * @description:
 * @version: 1.0.0
 */
@Mapper
public interface ProductUnitMapper {
    List<ProductUnit> selectAll();
}
