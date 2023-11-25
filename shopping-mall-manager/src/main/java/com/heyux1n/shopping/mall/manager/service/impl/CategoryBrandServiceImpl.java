package com.heyux1n.shopping.mall.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.heyux1n.shopping.mall.manager.mapper.CategoryBrandMapper;
import com.heyux1n.shopping.mall.manager.service.CategoryBrandService;
import com.heyux1n.shopping.mall.model.dto.product.CategoryBrandDto;
import com.heyux1n.shopping.mall.model.entity.product.CategoryBrand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: heyux1n
 * @date: 2023/11/25 17:43
 * @description:
 * @version: 1.0.0
 */
@Service
public class CategoryBrandServiceImpl implements CategoryBrandService {

    @Autowired
    private CategoryBrandMapper categoryBrandMapper;

    @Override
    public PageInfo<CategoryBrand> findByPage(Integer page, Integer limit, CategoryBrandDto categoryBrandDto) {
        PageHelper.startPage(page, limit);
        List<CategoryBrand> categoryBrandList = categoryBrandMapper.findByPage(categoryBrandDto);
        return new PageInfo<>(categoryBrandList);
    }

    @Override
    public boolean save(CategoryBrand categoryBrand) {
        return categoryBrandMapper.save(categoryBrand);
    }

    @Override
    public boolean updateById(CategoryBrand categoryBrand) {
        return categoryBrandMapper.updateById(categoryBrand);
    }

    @Override
    public boolean deleteById(Long id) {
        return categoryBrandMapper.deleteById(id);
    }
}
