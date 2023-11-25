package com.heyux1n.shopping.mall.manager.controller;

import com.heyux1n.shopping.mall.manager.service.CategoryService;
import com.heyux1n.shopping.mall.model.entity.product.Category;
import com.heyux1n.shopping.mall.model.vo.common.Result;
import com.heyux1n.shopping.mall.model.vo.common.ResultCodeEnum;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author: heyux1n
 * @date: 2023/11/19 11:18
 * @description:
 * @version: 1.0.0
 */
@RestController
@RequestMapping(value="/admin/product/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Operation(summary = "根据parentId获取下级节点")
    @GetMapping(value = "/findByParentId/{parentId}")
    public Result<List<Category>> findByParentId(@PathVariable Long parentId) {
        List<Category> list = categoryService.findByParentId(parentId);
        return Result.build(list , ResultCodeEnum.SUCCESS) ;
    }

    @Operation(summary = "导出分类数据")
    @GetMapping(value = "/exportData")
    public void exportData(HttpServletResponse response) {
        categoryService.exportData(response);
    }


    @Operation(summary = "导入分类数据")
    @PostMapping("importData")
    public Result importData(MultipartFile file) {
        categoryService.importData(file);
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }
}