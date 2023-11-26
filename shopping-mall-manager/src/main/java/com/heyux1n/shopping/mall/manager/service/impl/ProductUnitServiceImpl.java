package com.heyux1n.shopping.mall.manager.service.impl;

import com.heyux1n.shopping.mall.manager.mapper.ProductUnitMapper;
import com.heyux1n.shopping.mall.manager.service.ProductUnitService;
import com.heyux1n.shopping.mall.model.entity.product.ProductUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: heyux1n
 * @date: 2023/11/26 17:48
 * @description:
 * @version: 1.0.0
 */
@Service
public class ProductUnitServiceImpl implements ProductUnitService {
    @Autowired
    private ProductUnitMapper productUnitMapper;
    @Override
    public List<ProductUnit> findAll() {
        return productUnitMapper.selectAll();
    }
}
