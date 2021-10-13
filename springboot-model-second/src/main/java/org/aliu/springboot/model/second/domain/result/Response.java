package org.aliu.springboot.model.second.domain.result;

import lombok.Builder;
import lombok.Getter;
import org.aliu.springboot.model.second.domain.enums.HttpStatusCodeEnum;

/**
 * 统一返回格式
 *
 * @author liusheng
 * @date 2021/9/27
 */
@Getter
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

    /**
     * 统一失败
     *
     * @return
     */
    public static <T> Response fail(HttpStatusCodeEnum codeEnum) {
        ResponseBuilder<T> builder = new ResponseBuilder<T>();
        return builder.code(codeEnum.getCode()).
                message(codeEnum.getMessage()).
                success(Boolean.FALSE).build();
    }

    /**
     * 统一成功
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Response success(T data, HttpStatusCodeEnum codeEnum) {
        ResponseBuilder<T> builder = new ResponseBuilder<T>();
        return builder.code(codeEnum.getCode()).
                message(codeEnum.getMessage()).
                data(data).
                success(Boolean.TRUE).build();
    }

}
