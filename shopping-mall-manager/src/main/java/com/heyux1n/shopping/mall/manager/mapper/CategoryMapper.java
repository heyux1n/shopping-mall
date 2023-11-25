package com.heyux1n.shopping.mall.manager.mapper;

import com.heyux1n.shopping.mall.model.entity.product.Category;
import com.heyux1n.shopping.mall.model.vo.product.CategoryExcelVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: heyux1n
 * @date: 2023/11/19 11:20
 * @description:
 * @version: 1.0.0
 */
@Mapper
public interface CategoryMapper {
    /**
     * 根据父节点查询子节点列表
     * @param parentId
     * @return
     */
    List<Category> findByParentId(Long parentId);


    /**
     * 查询子节点数量
     * @param parentId
     * @return
     */
    int countByParentId(Long parentId);

    /**
     * 查询全部分类
     * @return
     */
    List<Category> selectAll();


    /**
     * 批量插入
     * @param categoryList
     */
    void batchInsert(List<CategoryExcelVo> categoryList);
}
