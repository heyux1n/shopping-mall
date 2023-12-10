package com.heyux1n.shopping.mall.service.product.service;

import com.github.pagehelper.PageInfo;
import com.heyux1n.shopping.mall.model.dto.h5.ProductSkuDto;
import com.heyux1n.shopping.mall.model.dto.h5.SkuSaleDto;
import com.heyux1n.shopping.mall.model.entity.product.ProductSku;
import com.heyux1n.shopping.mall.model.vo.h5.ProductItemVo;

import java.util.List;

/**
 * @author: heyux1n
 * @date: 2023/12/2 16:04
 * @description:
 * @version: 1.0.0
 */
public interface ProductService {
    /**
     * 通过销售量查询商品sku信息
     * @return
     */
    List<ProductSku> findProductSkuBySale();

    /**
     * 分页查询商品列表
     * @param page
     * @param limit
     * @param productSkuDto
     * @return
     */
    PageInfo<ProductSku> findByPage(Integer page, Integer limit, ProductSkuDto productSkuDto);

    /**
     * 商品
     * @param skuId
     * @return
     */
    ProductItemVo item(Long skuId);

    /**
     * 根据skuId查询sku信息
     * @param skuId
     * @return
     */
    ProductSku getBySkuId(Long skuId);

    /**
     * 更新销量
     * @param skuSaleDtoList
     * @return
     */
    Boolean updateSkuSaleNum(List<SkuSaleDto> skuSaleDtoList);
}
