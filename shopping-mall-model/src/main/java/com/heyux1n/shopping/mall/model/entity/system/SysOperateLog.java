package com.heyux1n.shopping.mall.model.entity.system;

import com.heyux1n.shopping.mall.model.entity.base.BaseEntity;
import lombok.Data;

/**
 * @author: heyux1n
 * @date: 2023/11/28 21:08
 * @description:
 * @version: 1.0.0
 */
@Data
public class SysOperateLog extends BaseEntity {

    /**
     *  模块标题
     */
    private String title;
    /**
     *  方法名称
     */
    private String method;
    /**
     *  请求方式
     */
    private String requestMethod;
    /**
     *  操作类别（0其它 1后台用户 2手机端用户）
     */
    private String operatorType;
    /**
     *  业务类型（0其它 1新增 2修改 3删除）
     */
    private Integer businessType ;
    /**
     *  操作人员
     */
    private String operateName;
    /**
     *  请求URL
     */
    private String operateUrl;
    /**
     *  主机地址
     */
    private String operateIp;
    /**
     *  请求参数
     */
    private String operateParam;
    /**
     *  返回参数
     */
    private String jsonResult;
    /**
     *  操作状态（0正常 1异常）
     */
    private Integer status;
    /**
     *  错误消息
     */
    private String errorMsg;

}