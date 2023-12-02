package com.heyux1n.shopping.mall.service.product.mapper;

import com.heyux1n.shopping.mall.model.entity.product.Product;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: heyux1n
 * @date: 2023/12/2 21:42
 * @description:
 * @version: 1.0.0
 */
@Mapper
public interface ProductMapper {
    /**
     * 根据id查询
     * @param id
     * @return
     */
    Product getById(Long id);
}
