package com.heyux1n.shopping.mall.service.product.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.heyux1n.shopping.mall.model.entity.product.Category;
import com.heyux1n.shopping.mall.service.product.mapper.CategoryMapper;
import com.heyux1n.shopping.mall.service.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: heyux1n
 * @date: 2023/12/2 16:05
 * @description:
 * @version: 1.0.0
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Cacheable(value = "category", key = "'first'")
    @Override
    public List<Category> findOneCategory() {
        return categoryMapper.findOneCategory();
    }

    @Cacheable(value = "category", key = "'tree'")
    @Override
    public List<Category> findCategoryTree() {
        List<Category> categoryList = categoryMapper.findAll();
        //全部一级分类
        List<Category> oneCategoryList = categoryList.stream().filter(item -> item.getParentId() == 0).toList();
        for (Category category : oneCategoryList) {
            List<Category> categoryChildList = getCategoryChild(category, categoryList);
            category.setHasChildren(CollectionUtil.isNotEmpty(categoryChildList));
            category.setChildren(categoryChildList);
        }
        return oneCategoryList;
    }


    private List<Category> getCategoryChild(Category category, List<Category> categoryList) {
        List<Category> childCategoryList = categoryList.stream().filter(c -> category.getId().equals(c.getParentId())).toList();
        if(CollectionUtil.isEmpty(childCategoryList)) {
            return null;
        }
        for (Category childCategory : childCategoryList) {
            List<Category> list = getCategoryChild(childCategory, categoryList);
            childCategory.setHasChildren(CollectionUtil.isNotEmpty(list));
            childCategory.setChildren(list);
        }
        return childCategoryList;
    }
}
