package org.example.openapi.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
@Order(1)
@Slf4j
public class TestFilter implements Filter {

    /**
     * https://www.readfog.com/a/1636486590853386240
     */

    @Override
    public void init(javax.servlet.FilterConfig filterConfig) throws ServletException {
        log.info("##############TestFilter init##############");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //在DispatcherServlet之前執行
        log.info("##############doFilter before##############");
        filterChain.doFilter(servletRequest, servletResponse);
        // 在視圖頁面返回給客戶端之前執行，但是執行順序在Interceptor之後
        log.info("##############doFilter after##############");
    }

    @Override
    public void destroy() {
        log.info("##############TestFilter destroy##############");
    }
}
