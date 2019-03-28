package com.oracle.hrb.zhzw.config;

import com.oracle.hrb.zhzw.intercepter.LoginIntercepter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class ZhzWConfig implements WebMvcConfigurer {
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginIntercepter())
                .addPathPatterns("/**")// 拦截多层目录
                .excludePathPatterns("/css/**")// 放行静态资源
                .excludePathPatterns("/fonts/**")
                .excludePathPatterns("/img/**")
                .excludePathPatterns("/js/**")
                .excludePathPatterns("/json/**");
    }
}
