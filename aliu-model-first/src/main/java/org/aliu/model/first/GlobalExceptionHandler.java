package org.aliu.model.first;

import lombok.extern.slf4j.Slf4j;
import org.aliu.model.first.domain.enums.HttpStatusCodeEnum;
import org.aliu.model.first.domain.result.ResponseResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * 全局异常处理
 *
 * @author liusheng
 * @date 2021/10/11
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {




    /**
     * 处理参数类型错误异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseResult handlerMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e){
        log.error("参数类型异常: {}",e.getMessage());
        return ResponseResult.fail(HttpStatusCodeEnum.PARAM_INVALID);
    }

    /**
     * 处理空指针异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(NullPointerException.class)
    public ResponseResult<Void> handlerNullPointerException(NullPointerException e) {
        log.error("发生空指针异常: {}", e.getMessage());
        return ResponseResult.fail(HttpStatusCodeEnum.SYSTEM_ERROR);
    }

    /**
     * 通用异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseResult<Void> handlerException(Exception e) {
        log.error("发生异常: {}", e.getMessage());
        return ResponseResult.fail(HttpStatusCodeEnum.SYSTEM_ERROR);
    }

}
