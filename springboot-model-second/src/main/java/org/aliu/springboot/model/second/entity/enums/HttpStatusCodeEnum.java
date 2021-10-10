package org.aliu.springboot.model.second.entity.enums;

/**
 * 状态码 枚举
 *
 * @author liusheng
 * @date 2021/9/27
 */
public enum HttpStatusCodeEnum {
    NOT_FOUND(401, "not information"),
    SYSTEM_ERROR(500,"系统异常,请联系管理员");


    HttpStatusCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }


    /**
     * 状态码
     */
    private Integer code;

    /**
     * 信息
     */
    private String message;
}
