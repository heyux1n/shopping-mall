package com.heyux1n.shopping.mall.manager.service;

import com.github.pagehelper.PageInfo;
import com.heyux1n.shopping.mall.model.entity.product.ProductSpec;

import java.util.List;

/**
 * @author: heyux1n
 * @date: 2023/11/26 16:40
 * @description:
 * @version: 1.0.0
 */
public interface ProductSpecService {
    /**
     * 分页查询
     * @param page
     * @param limit
     * @return
     */
    PageInfo<ProductSpec> findByPage(Integer page, Integer limit);

    /**
     * 新增
     * @param productSpec
     * @return
     */
    boolean save(ProductSpec productSpec);

    /**
     * 修改
     * @param productSpec
     * @return
     */
    boolean updateById(ProductSpec productSpec);

    /**
     * 删除
     * @param id
     * @return
     */
    boolean deleteById(Long id);

    /**
     * 查询全部商品规格
     * @return
     */
    List<ProductSpec> findAll();
}
