package com.heyux1n.shopping.mall.model.dto.system;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author: heyux1n
 * @date: 2023/11/4 21:46
 * @description:
 * @version: 1.0.0
 */

@Data
@Schema(description = "用户查询参数")
public class SysUserDto {
    @Schema(description = "关键字")
    private String keyword;
    @Schema(description = "开始时间")
    private String createTimeBegin;
    @Schema(description = "结束时间")
    private String createTimeEnd;
}
