package org.aliu.springboot.model.four.interceptor;

import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.aliu.springboot.model.four.exception.ErrorCodeEnum;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局限流拦截器
 *
 * @author liusheng
 * @date 2021/9/27
 */
@Slf4j
@Component
public class RateLimitInterceptor implements HandlerInterceptor {

    /**
     * 限流器实例 (QPS 限制为 10)
     */
    private static final RateLimiter rateLimiter = RateLimiter.create(2);


    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        //尝试获取令牌
        if (!rateLimiter.tryAcquire()){
            log.error("系统已被限流...");
            throw new RuntimeException(ErrorCodeEnum.RATE_LIMIT_ERROR.getMessage());
        }
        return true;
    }
}