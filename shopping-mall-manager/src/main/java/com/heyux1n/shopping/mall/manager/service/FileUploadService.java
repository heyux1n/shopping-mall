package com.heyux1n.shopping.mall.manager.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author: heyux1n
 * @date: 2023/11/5 14:40
 * @description:
 * @version: 1.0.0
 */
public interface FileUploadService {
    String fileUpload(MultipartFile multipartFile);
}
