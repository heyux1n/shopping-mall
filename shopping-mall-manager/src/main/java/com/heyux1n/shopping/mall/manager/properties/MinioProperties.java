package com.heyux1n.shopping.mall.manager.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: heyux1n
 * @date: 2023/11/5 14:47
 * @description:读取节点
 * @version: 1.0.0
 */
@Data
@ConfigurationProperties(prefix="shopping-mall.minio")
public class MinioProperties {

    private String endpointUrl;
    private String accessKey;
    private String secretKey;
    private String bucketName;

}