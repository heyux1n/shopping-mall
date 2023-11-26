package com.heyux1n.shopping.mall.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.heyux1n.shopping.mall.manager.mapper.ProductDetailsMapper;
import com.heyux1n.shopping.mall.manager.mapper.ProductMapper;
import com.heyux1n.shopping.mall.manager.mapper.ProductSkuMapper;
import com.heyux1n.shopping.mall.manager.service.ProductService;
import com.heyux1n.shopping.mall.model.dto.product.ProductDto;
import com.heyux1n.shopping.mall.model.entity.product.Product;
import com.heyux1n.shopping.mall.model.entity.product.ProductDetails;
import com.heyux1n.shopping.mall.model.entity.product.ProductSku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: heyux1n
 * @date: 2023/11/26 17:54
 * @description:
 * @version: 1.0.0
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductSkuMapper productSkuMapper;
    @Autowired
    private ProductDetailsMapper productDetailsMapper;

    @Override
    public PageInfo<Product> findByPage(Integer page, Integer limit, ProductDto productDto) {
        PageHelper.startPage(page, limit);
        List<Product> productList = productMapper.findByPage(productDto);
        return new PageInfo<>(productList);
    }

    @Override
    public boolean save(Product product) {
        //保存商品数据
        //设置上架状态为0
        product.setStatus(0);
        //设置审核状态为0
        product.setAuditStatus(0);
        productMapper.save(product);

        // 保存商品sku数据
        List<ProductSku> productSkuList = product.getProductSkuList();
        for (int i = 0, size = productSkuList.size(); i < size; i++) {
            //获取ProductSku对象
            ProductSku productSku = productSkuList.get(i);
            // 构建skuCode
            productSku.setSkuCode(product.getId() + "_" + i);
            //设置商品id
            productSku.setProductId(product.getId());
            productSku.setSkuName(product.getName() + productSku.getSkuSpec());
            //设置销量
            productSku.setSaleNum(0);
            productSku.setStatus(0);
            //保存数据
            productSkuMapper.save(productSku);
        }

        // 保存商品详情数据
        ProductDetails productDetails = new ProductDetails();
        productDetails.setProductId(product.getId());
        productDetails.setImageUrls(product.getDetailsImageUrls());
        productDetailsMapper.save(productDetails);
        return true;
    }

    @Override
    public Product getById(Long id) {
        Product product = productMapper.selectById(id);
        List<ProductSku> productSkus = productSkuMapper.selectByProductId(id);
        ProductDetails productDetails = productDetailsMapper.selectByProductId(id);
        product.setProductSkuList(productSkus);
        product.setDetailsImageUrls(productDetails.getImageUrls());
        return product;
    }

    @Override
    public boolean updateById(Product product) {
        // 修改商品基本数据
        productMapper.updateById(product);

        // 修改商品的sku数据
        List<ProductSku> productSkuList = product.getProductSkuList();
        productSkuList.forEach(productSku -> {
            productSkuMapper.updateById(productSku);
        });

        // 修改商品的详情数据
        ProductDetails productDetails = productDetailsMapper.selectByProductId(product.getId());
        productDetails.setImageUrls(product.getDetailsImageUrls());
        productDetailsMapper.updateById(productDetails);
        return true;
    }

    @Override
    public boolean deleteById(Long id) {
        productMapper.deleteById(id);
        productSkuMapper.deleteByProductId(id);
        productDetailsMapper.deleteByProductId(id);
        return true;
    }

    @Override
    public boolean updateAuditStatus(Long id, Integer auditStatus) {
        Product product = new Product();
        product.setId(id);
        if(auditStatus == 1) {
            product.setAuditStatus(1);
            product.setAuditMessage("审批通过");
        } else {
            product.setAuditStatus(-1);
            product.setAuditMessage("审批不通过");
        }
        productMapper.updateById(product);
        return true;
    }

    @Override
    public boolean updateStatus(Long id, Integer status) {
        Product product = new Product();
        product.setId(id);
        if(status == 1) {
            product.setStatus(1);
        } else {
            product.setStatus(-1);
        }
        productMapper.updateById(product);
        return true;
    }
}
