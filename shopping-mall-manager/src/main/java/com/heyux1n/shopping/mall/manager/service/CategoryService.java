package com.heyux1n.shopping.mall.manager.service;

import com.heyux1n.shopping.mall.model.entity.product.Category;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author: heyux1n
 * @date: 2023/11/19 11:18
 * @description:
 * @version: 1.0.0
 */
public interface CategoryService {
    List<Category> findByParentId(Long parentId);

    void exportData(HttpServletResponse response);

    void importData(MultipartFile file);
}
