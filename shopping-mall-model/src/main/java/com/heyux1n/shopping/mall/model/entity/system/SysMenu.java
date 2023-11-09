package com.heyux1n.shopping.mall.model.entity.system;

import com.heyux1n.shopping.mall.model.entity.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * @author: heyux1n
 * @date: 2023/11/9 20:13
 * @description:
 * @version: 1.0.0
 */
@Schema(description = "系统菜单")
@Data
public class SysMenu extends BaseEntity {

    @Schema(description = "父节点id")
    private Long parentId;
    @Schema(description = "标题")
    private String title;
    @Schema(description = "前端对应的组件")
    private String component;
    @Schema(description = "排序")
    private Integer sortValue;
    @Schema(description = "状态")
    private Integer status;
    @Schema(description = "子节点")
    private List<SysMenu> children;

}