package org.aliu.springboot.model.second.entity.result;

import lombok.Builder;
import org.aliu.springboot.model.second.entity.enums.HttpStatusCodeEnum;

/**
 * 统一返回格式
 *
 * @author liusheng
 * @date 2021/9/27
 */
@Builder
public class Response<T> {

    /**
     * 状态码
     */
    private final Integer code;

    /**
     * 信息
     */
    private final String message;

    /**
     * 数据
     */
    private final T data;

    /**
     * 成功状态
     */
    private final Boolean success;


    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public Boolean getSuccess() {
        return success;
    }

    /**
     * 统一失败操作
     *
     * @return
     */
    public static <T> Response fail() {
        ResponseBuilder<T> builder = new ResponseBuilder<T>();
        return builder.code(400).message("操作失败").success(Boolean.FALSE).build();
    }

    /**
     * 异常失败操作
     *
     * @return
     */
    public static <T> Response fail(HttpStatusCodeEnum codeEnum) {
        ResponseBuilder<T> builder = new ResponseBuilder<T>();
        return builder.code(codeEnum.getCode()).message(codeEnum.getMessage()).success(Boolean.FALSE).build();
    }

    /**
     * 统一成功操作
     * @param <T>
     * @return
     */
    public static <T> Response success() {
        ResponseBuilder<Object> builder = new ResponseBuilder<>();
        return builder.code(200).message("操作成功").success(Boolean.TRUE).build();
    }

    /**
     * 统一带数据的返回格式
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Response success(T data){
        ResponseBuilder<T> builder = new ResponseBuilder<T>();
        return builder.code(200).message("操作成功").data(data).success(Boolean.TRUE).build();
    }

}
