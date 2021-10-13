package org.aliu.springboot.model.four.config;

import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.aliu.springboot.model.four.interceptor.RateLimitInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web 配置类
 *
 * @author liusheng
 * @date 2021/9/27
 */
@Slf4j
@EnableWebMvc
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * 全局限流拦截器
     */
    @Autowired
    private RateLimitInterceptor rateLimitInterceptor;

    /**
     * 向Web 中添加拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //配置限流拦截器,拦截所有以 /api开头的请求
        registry.addInterceptor(rateLimitInterceptor)
                .addPathPatterns("/api/**");

    }

    /**
     * 静态资源配置
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("E:\\ideaProjects\\springboot-initialize\\springboot-model-four\\upload");
    }
}
