package com.heyux1n.shopping.mall.manager.service;

import com.github.pagehelper.PageInfo;
import com.heyux1n.shopping.mall.model.dto.product.CategoryBrandDto;
import com.heyux1n.shopping.mall.model.entity.product.CategoryBrand;

/**
 * @author: heyux1n
 * @date: 2023/11/25 17:42
 * @description:
 * @version: 1.0.0
 */
public interface CategoryBrandService {
    /**
     * 分页查询
     * @param page
     * @param limit
     * @param categoryBrandDto
     * @return
     */
    PageInfo<CategoryBrand> findByPage(Integer page, Integer limit, CategoryBrandDto categoryBrandDto);


    /**
     * 新增
     * @param categoryBrand
     * @return
     */
    boolean save(CategoryBrand categoryBrand);

    /**
     * 修改
     * @param categoryBrand
     * @return
     */
    boolean updateById(CategoryBrand categoryBrand);

    /**
     * 删除
     * @param id
     * @return
     */
    boolean deleteById(Long id);

}
