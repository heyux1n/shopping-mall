package com.heyux1n.shopping.mall.manager.interceptor;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.util.StringUtil;
import com.heyux1n.shopping.mall.common.exception.ServiceResException;
import com.heyux1n.shopping.mall.common.util.AuthContextUtil;
import com.heyux1n.shopping.mall.manager.properties.UserAuthProperties;
import com.heyux1n.shopping.mall.model.entity.system.SysUser;
import com.heyux1n.shopping.mall.model.vo.common.Result;
import com.heyux1n.shopping.mall.model.vo.common.ResultCodeEnum;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

/**
 * @author: heyux1n
 * @date: 2023/10/30 21:08
 * @description:
 * @version: 1.0.0
 */
@Component
public class LoginAuthInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1.预检验请求直接放行
        if(HttpMethod.OPTIONS.equals(request.getMethod())) {
            return true;
        }

        //2.从header中获取token
        //不存在直接响应208用户未登录
        String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);
        if(StringUtil.isEmpty(authorization) || !authorization.startsWith("Bearer")) {
            responseNoLoginInfo(response);
            return false;
        }

        //3.token去redis中获取token对应的用户信息
        //用户信息不存在则直接响应208用户未登录
        //"user:login:" + token
        String token = authorization.split(" ")[1];
        String sysUserJson = redisTemplate.opsForValue().get("user:login:" + token);
        if(StringUtil.isEmpty(sysUserJson)) {
            responseNoLoginInfo(response);
            return false;
        }
        SysUser sysUser = JSON.parseObject(sysUserJson, SysUser.class);

        //4.向ThreadLocal中存储用户信息并放行
        AuthContextUtil.set(sysUser);

        // 重置Redis中的用户数据的有效时间
        //TODO 为什么直接设置为30min
        redisTemplate.expire("user:login:" + token , 30 , TimeUnit.MINUTES) ;
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }


    private void responseNoLoginInfo(HttpServletResponse response) {
        Result<Object> result = Result.build(null, ResultCodeEnum.LOGIN_AUTH);
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        try {
            writer = response.getWriter();
            writer.print(JSON.toJSONString(result));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) writer.close();
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //响应结束则删除ThreadLocal中的用户数据
        AuthContextUtil.remove();
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
