package com.heyux1n.shopping.mall.common.service.interceptor;

import com.alibaba.fastjson.JSON;
import com.heyux1n.shopping.mall.common.service.util.AuthContextUtil;
import com.heyux1n.shopping.mall.model.entity.h5.UserInfo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author: heyux1n
 * @date: 2023/12/3 20:19
 * @description:
 * @version: 1.0.0
 */
public class UserLoginAuthInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 将token对应redis中用户信息当道threadLocal中
     *
     * @param request
     * @param response
     * @param handler
     * @return
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 如果token不为空，那么此时验证token的合法性
        String token = request.getHeader("token");
        String userInfoJSON = redisTemplate.opsForValue().get("user:login:" + token);
        if(StringUtils.hasText(userInfoJSON)) {
            AuthContextUtil.setUserInfo(JSON.parseObject(userInfoJSON, UserInfo.class));
        }
        return true;
    }
}
