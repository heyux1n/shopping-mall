package com.heyux1n.shopping.mall.model.vo.h5;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author: heyux1n
 * @date: 2023/12/3 20:07
 * @description:
 * @version: 1.0.0
 */
@Data
@Schema(description = "用户类")
public class UserInfoVo {

    @Schema(description = "昵称")
    private String nickName;

    @Schema(description = "头像")
    private String avatar;

}
