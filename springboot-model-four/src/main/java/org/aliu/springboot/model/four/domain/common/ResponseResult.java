package org.aliu.springboot.model.four.domain.common;

import lombok.Data;
import org.aliu.springboot.model.four.exception.ErrorCodeEnum;

import java.io.Serializable;

/**
 * 通用返回结果模型
 *
 * @author liusheng
 * @date 2021/9/27
 */
@Data
public class ResponseResult<T> implements Serializable {


    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -1316131482435884498L;

    /**
     * 状态码
     */
    private String code;

    /**
     * 信息
     */
    private String message;

    /**
     * 成功状态
     */
    private Boolean success;

    /**
     * 结果
     */
    private T result;

    /**
     * 通用成功
     *
     * @param message
     * @param <T>
     * @return
     */
    public static <T> ResponseResult success(String message) {
        ResponseResult<T> responseResult = new ResponseResult<>();
        responseResult.setSuccess(Boolean.TRUE);
        responseResult.setCode("200");
        responseResult.setMessage(message);
        return responseResult;
    }

    /**
     * 通用成功
     *
     * @param codeEnum
     * @param <T>
     * @return
     */
    public static <T> ResponseResult success(ErrorCodeEnum codeEnum) {
        ResponseResult<T> responseResult = new ResponseResult<>();
        responseResult.setSuccess(Boolean.TRUE);
        responseResult.setCode(codeEnum.getCode());
        responseResult.setMessage(codeEnum.getMessage());
        return responseResult;
    }

    /**
     * 通用成功
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResponseResult success(T data, ErrorCodeEnum codeEnum) {
        ResponseResult<T> responseResult = new ResponseResult<>();
        responseResult.setCode(codeEnum.getCode());
        responseResult.setMessage(codeEnum.getMessage());
        responseResult.setSuccess(Boolean.TRUE);
        responseResult.setResult(data);
        return responseResult;
    }

    /**
     * 通用失败
     *
     * @param code
     * @param message
     * @return
     */
    public static ResponseResult fail(String code, String message) {
        ResponseResult result = new ResponseResult<>();
        result.setCode(code);
        result.setMessage(message);
        result.setSuccess(Boolean.FALSE);
        return result;
    }

    /**
     * 枚举失败
     *
     * @param codeEnum
     * @return
     */
    public static ResponseResult fail(ErrorCodeEnum codeEnum) {
        return fail(codeEnum.getCode(), codeEnum.getMessage());
    }
}
