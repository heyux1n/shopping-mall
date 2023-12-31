package com.heyux1n.shopping.mall.model.dto.system;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * @author: heyux1n
 * @date: 2023/11/5 16:21
 * @description:
 * @version: 1.0.0
 */
@Schema(description = "分配角色")
@Data
public class AssignRoleDto {

    @Schema(description = "用户的id")
    private Long userId;
    @Schema(description = "角色id")
    private List<Long> roleIdList;

}