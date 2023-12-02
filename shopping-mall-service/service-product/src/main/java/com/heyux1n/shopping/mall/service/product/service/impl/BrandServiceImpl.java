package com.heyux1n.shopping.mall.service.product.service.impl;

import com.heyux1n.shopping.mall.model.entity.product.Brand;
import com.heyux1n.shopping.mall.service.product.mapper.BrandMapper;
import com.heyux1n.shopping.mall.service.product.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: heyux1n
 * @date: 2023/12/2 19:18
 * @description:
 * @version: 1.0.0
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    @Cacheable(value = "brand", key = "'list'")
    public List<Brand> findAll() {
        return brandMapper.findAll();
    }
}
