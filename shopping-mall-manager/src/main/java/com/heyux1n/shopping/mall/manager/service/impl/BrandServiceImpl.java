package com.heyux1n.shopping.mall.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.heyux1n.shopping.mall.manager.mapper.BrandMapper;
import com.heyux1n.shopping.mall.manager.service.BrandService;
import com.heyux1n.shopping.mall.model.entity.product.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: heyux1n
 * @date: 2023/11/25 15:26
 * @description:
 * @version: 1.0.0
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    protected BrandMapper brandMapper;


    @Override
    public PageInfo<Brand> findByPage(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<Brand> brandList = brandMapper.selectAll();
        return new PageInfo<>(brandList);
    }

    @Override
    public boolean save(Brand brand) {
        return brandMapper.save(brand);
    }

    @Override
    public boolean updateById(Brand brand) {
        return brandMapper.updateById(brand);
    }

    @Override
    public boolean deleteById(Long id) {
        return brandMapper.deleteById(id);
    }

    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }
}
