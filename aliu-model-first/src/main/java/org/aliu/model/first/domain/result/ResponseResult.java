package org.aliu.model.first.domain.result;

import org.aliu.model.first.domain.enums.HttpStatusCodeEnum;

/**
 * 统一返回格式
 * <p>
 * 注意要设置字段的 get方法,不然 MVC 在返回时不能获取到数据
 * </p>
 *
 * @author liusheng
 * @date 2021/10/9
 */
public class ResponseResult<T> {
    /**
     * 返回状态码
     */
    private final Integer code;

    /**
     * 返回信息
     */
    private final String message;

    /**
     * 返回数据
     */
    private final T data;

    /**
     * 是否成功
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
     * 构造带有数据的成功
     *
     * @param code
     * @param message
     * @param data
     * @param success
     */
    public ResponseResult(Integer code, String message, T data, Boolean success) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.success = success;
    }

    /**
     * 统一简单失败返回格式
     *
     * @return
     */
    public static ResponseResult fail() {
        return new ResponseResult(400, "操作失败", null, false);
    }

    /**
     * 统一简单成功返回格式
     *
     * @return
     */
    public static ResponseResult success() {
        return new ResponseResult(200, "操作成功", null, true);
    }

    /**
     * 统一带数据的返回格式
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResponseResult success(T data) {
        return new ResponseResult(200, "操作成功", data, true);
    }


    /**
     * 统一简单失败使用枚举返回格式
     *
     * @param httpStatusCodeEnum
     * @return
     */
    public static ResponseResult fail(HttpStatusCodeEnum httpStatusCodeEnum) {
        return new ResponseResult(httpStatusCodeEnum.getCode(), httpStatusCodeEnum.getMessage(), null, Boolean.FALSE);
    }

    /**
     * 统一简单成功使用枚举返回格式
     *
     * @param httpStatusCodeEnum
     * @return
     */
    public static ResponseResult success(HttpStatusCodeEnum httpStatusCodeEnum) {
        return new ResponseResult(httpStatusCodeEnum.getCode(), httpStatusCodeEnum.getMessage(), null, Boolean.TRUE);
    }

    /**
     * 统一简单成功使用枚举返回格式
     *
     * @param httpStatusCodeEnum
     * @return
     */
    public static <T> ResponseResult success(HttpStatusCodeEnum httpStatusCodeEnum, T data) {
        return new ResponseResult(httpStatusCodeEnum.getCode(), httpStatusCodeEnum.getMessage(), data, Boolean.TRUE);
    }

}
