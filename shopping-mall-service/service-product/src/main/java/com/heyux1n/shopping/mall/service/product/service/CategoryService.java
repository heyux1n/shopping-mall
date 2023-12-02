package com.heyux1n.shopping.mall.service.product.service;

import com.heyux1n.shopping.mall.model.entity.product.Category;

import java.util.List;

/**
 * @author: heyux1n
 * @date: 2023/12/2 16:04
 * @description:
 * @version: 1.0.0
 */
public interface CategoryService {
    /**
     * 查询一级分类
     * @return
     */
    List<Category> findOneCategory();

    /**
     * 查询分类树形
     * @return
     */
    List<Category> findCategoryTree();
}
