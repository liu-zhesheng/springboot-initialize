package org.aliu.springboot.model.four.exception;

import org.aliu.springboot.model.four.domain.common.ResponseResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 *
 * @author liusheng
 * @date 2021/10/13
 */
@RestControllerAdvice
public class GlobalExceptionHandler {



    /**
     * 处理运行时异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseResult handlerRuntimeException(RuntimeException e) {
        return ResponseResult.fail(
                ErrorCodeEnum.UNKNOWN_ERROR.getCode(),
                e.getMessage());
    }



    /**
     * 处理系统级异常
     *
     * @param throwable
     * @return
     */
    @ExceptionHandler(Throwable.class)
    public ResponseResult handlerThrowable(Throwable throwable) {
        return ResponseResult.fail(
                ErrorCodeEnum.UNKNOWN_ERROR.getCode(),
                throwable.getMessage());
    }
}
