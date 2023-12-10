package com.heyux1n.shopping.mall.service.cart.service;

import com.heyux1n.shopping.mall.model.entity.h5.CartInfo;

import java.util.List;

/**
 * @author: heyux1n
 * @date: 2023/12/9 18:12
 * @description:
 * @version: 1.0.0
 */
public interface CartService {
    /**
     * 添加商品至购物车
     * @param skuId
     * @param skuNum
     */
    void addToCart(Long skuId, Integer skuNum);

    /**
     * 查询购物车列表
     * @return
     */
    List<CartInfo> getCartList();


    /**
     * 删除指定上坪
     * @param skuId
     */
    void deleteCart(Long skuId);

    /**
     * 改变选中状态
     * @param skuId
     * @param isChecked
     */
    void checkCart(Long skuId, Integer isChecked);

    /**
     * 全选
     * @param isChecked
     */
    void allCheckCart(Integer isChecked);

    /**
     * 清空购物车
     */
    void clearCart();

    /**
     * 查询选中
     * @return
     */
    List<CartInfo> getAllChecked();

    /**
     * 删除选中
     */
    void deleteChecked();
}
