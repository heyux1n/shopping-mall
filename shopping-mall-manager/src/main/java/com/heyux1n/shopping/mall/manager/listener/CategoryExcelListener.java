package com.heyux1n.shopping.mall.manager.listener;

import com.heyux1n.shopping.mall.manager.mapper.CategoryMapper;
import com.heyux1n.shopping.mall.model.vo.product.CategoryExcelVo;

import java.util.List;

/**
 * @author: heyux1n
 * @date: 2023/11/25 12:31
 * @description:
 * @version: 1.0.0
 */
public class CategoryExcelListener<T> extends ExcelListener<T>{

    private CategoryMapper categoryMapper;

    public CategoryExcelListener(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    @Override
    public void saveData(List<T> cachedDataList) {
        categoryMapper.batchInsert((List<CategoryExcelVo>) cachedDataList);
    }
}
