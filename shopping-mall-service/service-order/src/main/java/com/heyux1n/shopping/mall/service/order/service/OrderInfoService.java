package com.heyux1n.shopping.mall.service.order.service;

import com.heyux1n.shopping.mall.model.vo.h5.order.TradeVo;

/**
 * @author: heyux1n
 * @date: 2023/12/9 19:58
 * @description:
 * @version: 1.0.0
 */
public interface OrderInfoService {
    /**
     * 获取结算数据
     * @return
     */
    TradeVo getTrade();
}
