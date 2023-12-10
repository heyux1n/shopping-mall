package com.heyux1n.shopping.mall.service.product.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.heyux1n.shopping.mall.model.dto.h5.ProductSkuDto;
import com.heyux1n.shopping.mall.model.dto.h5.SkuSaleDto;
import com.heyux1n.shopping.mall.model.entity.product.Product;
import com.heyux1n.shopping.mall.model.entity.product.ProductDetails;
import com.heyux1n.shopping.mall.model.entity.product.ProductSku;
import com.heyux1n.shopping.mall.model.vo.h5.ProductItemVo;
import com.heyux1n.shopping.mall.service.product.mapper.ProductDetailsMapper;
import com.heyux1n.shopping.mall.service.product.mapper.ProductMapper;
import com.heyux1n.shopping.mall.service.product.mapper.ProductSkuMapper;
import com.heyux1n.shopping.mall.service.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: heyux1n
 * @date: 2023/12/2 16:05
 * @description:
 * @version: 1.0.0
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductSkuMapper productSkuMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductDetailsMapper productDetailsMapper;

    @Override
    public List<ProductSku> findProductSkuBySale() {
        return productSkuMapper.findProductSkuBySale();
    }

    @Override
    public PageInfo<ProductSku> findByPage(Integer page, Integer limit, ProductSkuDto productSkuDto) {
        PageHelper.startPage(page, limit);
        List<ProductSku> productSkuList = productSkuMapper.findByPage(productSkuDto);
        return new PageInfo<>(productSkuList);
    }

    @Override
    public ProductItemVo item(Long skuId) {
        //当前sku信息
        ProductSku productSku = productSkuMapper.getById(skuId);

        //当前商品信息
        Product product = productMapper.getById(productSku.getProductId());

        //同一个商品下面的sku信息列表
        List<ProductSku> productSkuList = productSkuMapper.findByProductId(productSku.getProductId());
        //建立sku规格与skuId对应关系
        Map<String, Object> skuSpecValueMap = new HashMap<>(16);
        productSkuList.forEach(item -> {
            skuSpecValueMap.put(item.getSkuSpec(), item.getId());
        });

        //商品详情信息
        ProductDetails productDetails = productDetailsMapper.getByProductId(productSku.getProductId());

        ProductItemVo productItemVo = new ProductItemVo();
        productItemVo.setProductSku(productSku);
        productItemVo.setProduct(product);
        productItemVo.setDetailsImageUrlList(Arrays.asList(productDetails.getImageUrls().split(",")));
        productItemVo.setSliderUrlList(Arrays.asList(product.getSliderUrls().split(",")));
        productItemVo.setSpecValueList(JSON.parseArray(product.getSpecValue()));
        productItemVo.setSkuSpecValueMap(skuSpecValueMap);
        return productItemVo;
    }

    @Override
    public ProductSku getBySkuId(Long skuId) {
        return productSkuMapper.getById(skuId);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean updateSkuSaleNum(List<SkuSaleDto> skuSaleDtoList) {
        if (CollectionUtils.isEmpty(skuSaleDtoList)) {
            return true;
        }
        for (SkuSaleDto skuSaleDto : skuSaleDtoList) {
            productSkuMapper.updateSale(skuSaleDto.getSkuId(), skuSaleDto.getNum());
        }
        return true;
    }
}
