package com.heyux1n.shopping.mall.client.cart.feign;

import com.heyux1n.shopping.mall.model.entity.h5.CartInfo;
import com.heyux1n.shopping.mall.model.vo.common.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author: heyux1n
 * @date: 2023/12/9 19:25
 * @description:
 * @version: 1.0.0
 */
@FeignClient(value = "service-cart")
public interface CartFeignClient {

    /**
     * 获取购物车全部选中商品
     * @return
     */
    @GetMapping(value = "/api/order/cart/auth/getAllChecked")
    public abstract List<CartInfo> getAllChecked() ;


    /**
     * 删除已选中
     * @return
     */
    @GetMapping(value = "/api/order/cart/auth/deleteChecked")
    public abstract Result deleteChecked();
}