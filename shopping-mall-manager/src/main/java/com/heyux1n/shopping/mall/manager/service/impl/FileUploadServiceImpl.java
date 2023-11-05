package com.heyux1n.shopping.mall.manager.service.impl;

import cn.hutool.core.date.DateUtil;
import com.heyux1n.shopping.mall.manager.properties.MinioProperties;
import com.heyux1n.shopping.mall.manager.service.FileUploadService;
import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.UUID;

/**
 * @author: heyux1n
 * @date: 2023/11/5 14:41
 * @description:
 * @version: 1.0.0
 */
@Service
public class FileUploadServiceImpl implements FileUploadService {

    @Autowired
    private MinioProperties minioProperties;

    @Override
    public String fileUpload(MultipartFile multipartFile) {
        try {
            // 通过用户名密码创建minioClient
            MinioClient minioClient =
                    MinioClient.builder()
                            .endpoint(minioProperties.getEndpointUrl())
                            .credentials(minioProperties.getAccessKey(), minioProperties.getSecretKey())
                            .build();

            //判断bucket是否存在
            boolean found = minioClient.bucketExists(BucketExistsArgs.builder().bucket(minioProperties.getBucketName()).build());
            if (!found) {
                //不存在则创建对应的bucket
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(minioProperties.getBucketName()).build());
            } else {
                System.out.println("Bucket " + minioProperties.getBucketName() + " already exists.");
            }
            // 设置存储对象名称
            String dateDir = DateUtil.format(new Date(), "yyyyMMdd");
            String uuid = UUID.randomUUID().toString().replace("-", "");
            String fileName = dateDir + "/" + uuid + "-" + multipartFile.getOriginalFilename();
            // 通过流上传文件
            minioClient.putObject(
                    PutObjectArgs.builder().bucket(minioProperties.getBucketName()).object(fileName).stream(
                                    multipartFile.getInputStream(), multipartFile.getSize(), -1)
                            .contentType("video/mp4")
                            .build());
            return minioProperties.getEndpointUrl() + "/" + minioProperties.getBucketName() + "/" + fileName ;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
