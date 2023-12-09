package com.heyux1n.shopping.mall.client.product.feign;

import com.heyux1n.shopping.mall.model.entity.product.ProductSku;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: heyux1n
 * @date: 2023/12/9 18:06
 * @description:
 * @version: 1.0.0
 */
@FeignClient(value = "service-product")
public interface ProductFeignClient {

    /**
     * 查询商品sku
     * @param skuId
     * @return
     */
    @GetMapping("/api/product/getBySkuId/{skuId}")
    public abstract ProductSku getBySkuId(@PathVariable Long skuId);

}
