package com.heyux1n.shopping.mall.manager.mapper;

import com.heyux1n.shopping.mall.model.dto.product.CategoryBrandDto;
import com.heyux1n.shopping.mall.model.entity.product.Brand;
import com.heyux1n.shopping.mall.model.entity.product.CategoryBrand;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: heyux1n
 * @date: 2023/11/25 17:44
 * @description:
 * @version: 1.0.0
 */
@Mapper
public interface CategoryBrandMapper {

    List<CategoryBrand> findByPage(CategoryBrandDto categoryBrandDto);

    boolean save(CategoryBrand categoryBrand);

    boolean updateById(CategoryBrand categoryBrand);

    boolean deleteById(Long id);

    List<Brand> findBrandByCategoryId(Long categoryId);
}
