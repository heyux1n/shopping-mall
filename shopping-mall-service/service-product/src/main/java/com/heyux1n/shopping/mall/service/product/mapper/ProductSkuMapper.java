package com.heyux1n.shopping.mall.service.product.mapper;

import com.heyux1n.shopping.mall.model.dto.h5.ProductSkuDto;
import com.heyux1n.shopping.mall.model.entity.product.ProductSku;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: heyux1n
 * @date: 2023/12/2 16:16
 * @description:
 * @version: 1.0.0
 */
@Mapper
public interface ProductSkuMapper {
    /**
     * 根据销量查询商品sku信息
     * @return
     */
    List<ProductSku> findProductSkuBySale();

    /**
     * 分页查询商品sku
     * @param productSkuDto
     * @return
     */
    List<ProductSku> findByPage(ProductSkuDto productSkuDto);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    ProductSku getById(Long id);

    /**
     * 根据productId查询sku列表
     * @param productId
     * @return
     */
    List<ProductSku> findByProductId(Long productId);

    /**
     * 更新销量
     * @param skuId
     * @param num
     */
    void updateSale(Long skuId, Integer num);
}
