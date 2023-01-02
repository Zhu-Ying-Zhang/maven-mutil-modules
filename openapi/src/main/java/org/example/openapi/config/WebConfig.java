package org.example.openapi.config;

import lombok.extern.slf4j.Slf4j;
import org.example.openapi.interceptor.TestInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
@Slf4j
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("[Add new interceptor to project!]");
        registry.addInterceptor(new TestInterceptor());
    }
}
