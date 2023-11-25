package com.heyux1n.shopping.mall.manager.service;

import com.github.pagehelper.PageInfo;
import com.heyux1n.shopping.mall.model.entity.product.Brand;

/**
 * @author: heyux1n
 * @date: 2023/11/25 15:25
 * @description:
 * @version: 1.0.0
 */
public interface BrandService {
    /**
     * 分页查询
     * @param page
     * @param limit
     * @return
     */
    PageInfo<Brand> findByPage(Integer page, Integer limit);

    /**
     * 新增
     * @param brand
     * @return
     */
    boolean save(Brand brand);

    /**
     * 修改
     * @param brand
     * @return
     */
    boolean updateById(Brand brand);

    /**
     * 删除
     * @param id
     * @return
     */
    boolean deleteById(Long id);
}
