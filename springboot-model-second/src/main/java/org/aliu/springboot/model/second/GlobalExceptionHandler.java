package org.aliu.springboot.model.second;

import lombok.extern.slf4j.Slf4j;
import org.aliu.springboot.model.second.entity.enums.HttpStatusCodeEnum;
import org.aliu.springboot.model.second.entity.result.Response;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


/**
 * 全局异常处理
 *
 * @author liusheng
 * @date 2021/9/27
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {



    /**
     * 处理参数类型错误异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public Response handlerMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e){
        log.error("参数类型异常: {}",e.getMessage());
        return Response.fail(HttpStatusCodeEnum.PARAM_INVALID);
    }


    /**
     * 系统异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Response handleException(Exception e) {
        log.error("异常: {} , 信息:{}", e.getClass(), e.getMessage());
        return Response.fail(HttpStatusCodeEnum.SYSTEM_ERROR);
    }

}
