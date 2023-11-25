package com.heyux1n.shopping.mall.manager.mapper;

import com.heyux1n.shopping.mall.model.entity.product.Brand;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: heyux1n
 * @date: 2023/11/25 15:28
 * @description:
 * @version: 1.0.0
 */
@Mapper
public interface BrandMapper {
    /**
     * 查询全部
     * @return
     */
     List<Brand> findByPage();

    /**
     * 系只能
     * @param brand
     * @return
     */
    boolean save(Brand brand);

    /**
     * 更新
     * @param brand
     * @return
     */
    boolean updateById(Brand brand);

    /**
     * 删除
     * @param id
     * @return
     */
    boolean deleteById(Long id);
}
