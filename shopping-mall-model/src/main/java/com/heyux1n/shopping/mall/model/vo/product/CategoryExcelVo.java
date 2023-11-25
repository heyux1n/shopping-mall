package com.heyux1n.shopping.mall.model.vo.product;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author: heyux1n
 * @date: 2023/11/19 16:26
 * @description:
 * @version: 1.0.0
 */
@Data
public class CategoryExcelVo {

    @ExcelProperty(value = "id" ,index = 0)
    private Long id;

    @ExcelProperty(value = "名称" ,index = 1)
    private String name;

    @ExcelProperty(value = "图片url" ,index = 2)
    private String imageUrl ;

    @ExcelProperty(value = "上级id" ,index = 3)
    private Long parentId;

    @ExcelProperty(value = "状态" ,index = 4)
    private Integer status;

    @ExcelProperty(value = "排序" ,index = 5)
    private Integer orderNum;
}