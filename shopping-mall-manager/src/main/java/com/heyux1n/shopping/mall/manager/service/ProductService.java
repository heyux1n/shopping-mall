package com.heyux1n.shopping.mall.manager.service;

import com.github.pagehelper.PageInfo;
import com.heyux1n.shopping.mall.model.dto.product.ProductDto;
import com.heyux1n.shopping.mall.model.entity.product.Product;

/**
 * @author: heyux1n
 * @date: 2023/11/26 17:54
 * @description:
 * @version: 1.0.0
 */
public interface ProductService {
    PageInfo<Product> findByPage(Integer page, Integer limit, ProductDto productDto);

    boolean save(Product product);

    Product getById(Long id);

    boolean updateById(Product product);

    boolean deleteById(Long id);

    boolean updateAuditStatus(Long id, Integer auditStatus);

    boolean updateStatus(Long id, Integer status);
}
