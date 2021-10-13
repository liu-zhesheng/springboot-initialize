package org.aliu.springboot.model.four.aspect;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aliu.springboot.model.four.utils.ValidatorUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Validator;

/**
 * @author liusheng
 * @date 2021/10/13
 */
@Component
@Aspect
public class Log {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final ObjectMapper objectMapper;


    @Autowired
    private HttpServletRequest request;

    public Log(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Pointcut("execution(* org.aliu.springboot.model.four.controller.*.*(..))")
    public void api() {
    }

    /**
     * 环绕通知处理controller 接口日志
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
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
            failLogInfo(uri, method, params, begin, logger);
            throw e;
        }
        successLogInfo(result, uri, method, params, begin, logger);
        return result;
    }

    private void failLogInfo(String uri, String method, String params, long begin, Logger logger) {
        logger.error("***********************");
        logger.error("api:{} ", uri);
        logger.error("method:{}", method);
        logger.error("params:{}", params);
        logger.error("fail with {}ms", System.currentTimeMillis() - begin);
        logger.error("***********************");

    }

    private void successLogInfo(Object result, String uri, String method, String params, long begin, Logger logger) {
        logger.info("***********************");
        logger.info("api:{} ", uri);
        logger.info("method:{}", method);
        logger.info("params:{}", params);
        logger.info("return:{}", JSON.toJSONString(result, true));
        logger.info("success with {}ms", System.currentTimeMillis() - begin);
        logger.info("***********************");

    }

    private String toJson(Object[] args) {
        try {
            return objectMapper.writeValueAsString(args);
        } catch (JsonProcessingException e) {
            return "[args]";
        }
    }
}
