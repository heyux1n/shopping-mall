package com.heyux1n.shopping.mall.service.product.mapper;

import com.heyux1n.shopping.mall.model.entity.product.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: heyux1n
 * @date: 2023/12/2 16:08
 * @description:
 * @version: 1.0.0
 */
@Mapper
public interface CategoryMapper {
    /**
     * 查询一级分类
     * @return
     */
    List<Category> findOneCategory();

    /**
     * 查询全部分类
     * @return
     */
    List<Category> findAll();
}
