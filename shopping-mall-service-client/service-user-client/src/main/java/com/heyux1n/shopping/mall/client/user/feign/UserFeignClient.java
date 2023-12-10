package com.heyux1n.shopping.mall.client.user.feign;

import com.heyux1n.shopping.mall.model.entity.h5.UserAddress;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: heyux1n
 * @date: 2023/12/10 18:01
 * @description:
 * @version: 1.0.0
 */
@FeignClient("service-user")
public interface UserFeignClient {

    /**
     * 根据地址id查询地址信息
     * @param id
     * @return
     */
    @GetMapping("/api/user/userAddress/getUserAddress/{id}")
    public abstract UserAddress getUserAddress(@PathVariable Long id);
}
