package com.heyux1n.shopping.mall.service.product.mapper;

import com.heyux1n.shopping.mall.model.entity.product.Brand;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: heyux1n
 * @date: 2023/12/2 19:18
 * @description:
 * @version: 1.0.0
 */
@Mapper
public interface BrandMapper {
    /**
     * 查询全部品牌信息
     * @return
     */
    List<Brand> findAll();
}
