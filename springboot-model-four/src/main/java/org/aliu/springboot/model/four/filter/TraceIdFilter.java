package org.aliu.springboot.model.four.filter;

import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.UUID;

/**
 * TraceId过滤器
 *
 * @author liusheng
 * @date 2021/9/27
 */
@Order(1)
@WebFilter(urlPatterns = "/*")
public class TraceIdFilter implements Filter {

    private static final String TRACE_ID = "traceId";


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        //尝试从请求中获取TraceId
        String traceId = servletRequest.getParameter(TRACE_ID);

        //为空设置默认值
        if (StringUtils.isEmpty(traceId)) {
            traceId = UUID.randomUUID().toString();
        }

        //在MDC中放入traceId  MDC是日志框架提供的一个 当前线程的map
        MDC.put(TRACE_ID, traceId);

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
