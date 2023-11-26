package com.heyux1n.shopping.mall.manager.mapper;

import com.heyux1n.shopping.mall.model.dto.product.ProductDto;
import com.heyux1n.shopping.mall.model.entity.product.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: heyux1n
 * @date: 2023/11/26 17:56
 * @description:
 * @version: 1.0.0
 */
@Mapper
public interface ProductMapper {

    List<Product> findByPage(ProductDto productDto);

    boolean save(Product product);

    Product selectById(Long id);

    boolean updateById(Product product);

    boolean deleteById(Long id);

}
