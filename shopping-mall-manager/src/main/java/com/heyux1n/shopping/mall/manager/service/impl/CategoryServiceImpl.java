package com.heyux1n.shopping.mall.manager.service.impl;

import com.alibaba.excel.EasyExcel;
import com.heyux1n.shopping.mall.common.exception.ServiceResException;
import com.heyux1n.shopping.mall.manager.listener.CategoryExcelListener;
import com.heyux1n.shopping.mall.manager.mapper.CategoryMapper;
import com.heyux1n.shopping.mall.manager.service.CategoryService;
import com.heyux1n.shopping.mall.model.entity.product.Category;
import com.heyux1n.shopping.mall.model.vo.common.ResultCodeEnum;
import com.heyux1n.shopping.mall.model.vo.product.CategoryExcelVo;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: heyux1n
 * @date: 2023/11/19 11:19
 * @description:
 * @version: 1.0.0
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> findByParentId(Long parentId) {
        List<Category> categoryList = categoryMapper.findByParentId(parentId);
        categoryList.forEach(category -> {
            int i = categoryMapper.countByParentId(category.getId());
            category.setHasChildren(i > 0);
        });
        return categoryList;
    }

    @Override
    public void exportData(HttpServletResponse response) {
        // 设置响应结果类型
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding(StandardCharsets.UTF_8.toString());

        try {
            // 这里URLEncoder.encode可以防止中文乱码 当然和EasyExcel没有关系
            String fileName = URLEncoder.encode("分类数据", StandardCharsets.UTF_8);
            response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");

            // 查询数据库中的数据
            List<Category> categoryList = categoryMapper.selectAll();
            List<CategoryExcelVo> categoryExcelVoList = new ArrayList<>(categoryList.size());
            // 将从数据库中查询到的Category对象转换成CategoryExcelVo对象
            for (Category category : categoryList) {
                CategoryExcelVo categoryExcelVo = new CategoryExcelVo();
                BeanUtils.copyProperties(category, categoryExcelVo, CategoryExcelVo.class);
                categoryExcelVoList.add(categoryExcelVo);
            }
            // 写出数据到浏览器端
            EasyExcel.write(response.getOutputStream(), CategoryExcelVo.class).sheet("分类数据").doWrite(categoryExcelVoList);

        } catch (IOException e) {
            throw new ServiceResException(ResultCodeEnum.CATEGORY_EXPORT_ERROR);
        }
    }

    @Override
    public void importData(MultipartFile file) {
        try {
            EasyExcel.read(file.getInputStream(), CategoryExcelVo.class, new CategoryExcelListener<CategoryExcelVo>(categoryMapper)).sheet().doRead();
        } catch (IOException e) {
            throw new ServiceResException(ResultCodeEnum.CATEGORY_EXPORT_ERROR);
        }
    }
}
