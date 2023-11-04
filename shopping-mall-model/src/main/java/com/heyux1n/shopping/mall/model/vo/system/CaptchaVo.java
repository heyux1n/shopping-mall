package com.heyux1n.shopping.mall.model.vo.system;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author: heyux1n
 * @date: 2023/10/29 11:33
 * @description: 验证码响应
 * @version: 1.0.0
 */
@Data
@Schema(description = "验证码响应结果")
public class CaptchaVo {

    @Schema(description = "验证码key")
    private String codeKey;

    @Schema(description = "验证码value，验证码图片base64数据")
    private String codeValue;

}