package com.heyux1n.shopping.mall.client.product.feign;

import com.heyux1n.shopping.mall.model.dto.h5.SkuSaleDto;
import com.heyux1n.shopping.mall.model.entity.product.ProductSku;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

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

    /**
     * 更新商品销量
     * @param skuSaleDtoList
     * @return
     */
    @PostMapping("/api/product/updateSkuSaleNum")
    Boolean updateSkuSaleNum(@RequestBody List<SkuSaleDto> skuSaleDtoList);
}
