package com.bluemoon.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Mở cửa cho toàn bộ API trong hệ thống
                .allowedOriginPatterns("*") // Cho phép mọi Frontend kết nối (React, Vue, Live Server...)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // BẮT BUỘC có OPTIONS để sửa lỗi Preflight
                .allowedHeaders("*")
                .allowCredentials(false); 
    }
}
