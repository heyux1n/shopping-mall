package com.heyux1n.shopping.mall.service.user.service.impl;

import com.heyux1n.shopping.mall.common.service.exception.ServiceResException;
import com.heyux1n.shopping.mall.common.util.HttpUtils;
import com.heyux1n.shopping.mall.model.vo.common.ResultCodeEnum;
import com.heyux1n.shopping.mall.service.user.properties.SmsProperties;
import com.heyux1n.shopping.mall.service.user.service.SmsService;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author: heyux1n
 * @date: 2023/12/3 17:26
 * @description:
 * @version: 1.0.0
 */
@Service
public class SmsServiceImpl implements SmsService {

    @Autowired
    private SmsProperties smsProperties;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public void sendCaptcha(String phone) {
        String code = redisTemplate.opsForValue().get("phone:code:" + phone);
        if (StringUtils.hasText(code)) {
            return;
        }

        // 生成验证码
        String validateCode = RandomStringUtils.randomNumeric(4);
        try {
            sendSms(phone, validateCode);
            //发送成功后存入redis
            redisTemplate.opsForValue().set("phone:code:" + phone, validateCode, 5, TimeUnit.MINUTES);
        } catch (Exception e) {
            throw new ServiceResException(ResultCodeEnum.SYSTEM_ERROR);
        }
    }


    /**
     * 发送短信方法
     *
     * @param phone
     * @param captcha
     */
    public void sendSms(String phone, String captcha) throws Exception {

        String method = "POST";
        Map<String, String> headers = new HashMap<>(16);
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + smsProperties.getAppcode());
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();
        Map<String, String> bodys = new HashMap<String, String>();
        bodys.put("content", "code:" + captcha);
        bodys.put("template_id", "CST_ptdie100");
        bodys.put("phone_number", phone);

        /**
         * 重要提示如下:
         * HttpUtils请从
         * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
         * 下载
         *
         * 相应的依赖请参照
         * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
         */
        HttpResponse response = HttpUtils.doPost(smsProperties.getHost(), smsProperties.getPath(), method, headers, querys, bodys);
        System.out.println(response.toString());
    }
}
