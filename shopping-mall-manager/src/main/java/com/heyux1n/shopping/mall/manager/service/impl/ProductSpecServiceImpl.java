package com.heyux1n.shopping.mall.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.heyux1n.shopping.mall.manager.mapper.ProductSpecMapper;
import com.heyux1n.shopping.mall.manager.service.ProductSpecService;
import com.heyux1n.shopping.mall.model.entity.product.ProductSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: heyux1n
 * @date: 2023/11/26 16:40
 * @description:
 * @version: 1.0.0
 */
@Service
public class ProductSpecServiceImpl implements ProductSpecService {

    @Autowired
    private ProductSpecMapper productSpecMapper;

    @Override
    public PageInfo<ProductSpec> findByPage(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<ProductSpec> ProductSpecList = productSpecMapper.selectAll();
        return new PageInfo<>(ProductSpecList);
    }

    @Override
    public boolean save(ProductSpec productSpec) {
        return productSpecMapper.save(productSpec);
    }

    @Override
    public boolean updateById(ProductSpec productSpec) {
        return productSpecMapper.updateById(productSpec);
    }

    @Override
    public boolean deleteById(Long id) {
        return productSpecMapper.deleteById(id);
    }

    @Override
    public List<ProductSpec> findAll() {
        return productSpecMapper.selectAll();
    }
}
