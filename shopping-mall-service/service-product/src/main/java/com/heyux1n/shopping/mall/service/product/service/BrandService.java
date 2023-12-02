package com.heyux1n.shopping.mall.service.product.service;

import com.heyux1n.shopping.mall.model.entity.product.Brand;

import java.util.List;

/**
 * @author: heyux1n
 * @date: 2023/12/2 19:11
 * @description:
 * @version: 1.0.0
 */
public interface BrandService {
    /**
     * 查询全部品牌
     * @return
     */
    List<Brand> findAll();
}
