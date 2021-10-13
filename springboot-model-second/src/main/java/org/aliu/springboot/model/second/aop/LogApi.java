package org.aliu.springboot.model.second.aop;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 日志切面处理类
 *
 * @author liusheng
 * @date 2021/9/27
 */
@Aspect
@Component
public class LogApi {


    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final ObjectMapper objectMapper;


    @Autowired
    private HttpServletRequest request;

    public LogApi(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Pointcut("execution(* org.aliu.springboot.model.second.controller.*.*(..))")
    public void api() {
    }

    @Around("api()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        Object result;
        String uri = request.getRequestURI();
        String method = request.getMethod();
        String params = toJson(args);
        long begin = System.currentTimeMillis();
        try {
            result = joinPoint.proceed();
        } catch (Exception e) {
            logger.error("api:{} method:{} params:{} error with {}ms", uri, method, params, System.currentTimeMillis() - begin);
            throw e;
        }
        logger.info("api:{} ", uri);
        logger.info("method:{}", method);
        logger.info("params:{}", params);
        logger.info("return:{}", JSON.toJSONString(result,true));
        logger.info("success with {}ms", System.currentTimeMillis() - begin);
        return result;
    }

    private String toJson(Object[] args) {
        try {
            return objectMapper.writeValueAsString(args);
        } catch (JsonProcessingException e) {
            return "[args]";
        }
    }
}
