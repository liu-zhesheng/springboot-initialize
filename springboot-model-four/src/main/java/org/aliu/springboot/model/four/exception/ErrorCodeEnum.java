package org.aliu.springboot.model.four.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 异常编码枚举
 *
 * @author liusheng
 * @date 2021/9/27
 */
@Getter
@AllArgsConstructor
public enum ErrorCodeEnum {

    //0*** 成功
    SUCCESS("0000", "操作成功"),

    //1*** 参数异常
    PARAM_ERROR("1001", "参数异常"),
    PARAM_NULL("1002", "参数为空"),
    PARAM_FORMAT_ERROR("1003", "参数格式不正确"),
    PARAM_VALUE_ERROR("1004", "参数值不正确"),

    //2***  系统异常
    SYSTEM_ERROR("2001", "系统异常"),
    UNKNOWN_ERROR("2002", "未知异常"),


    //3**** 业务异常
    XXX("3001", "业务异常"),
    INSERT_ERROR("3002","新增失败");
    private String code;

    private String message;

}
