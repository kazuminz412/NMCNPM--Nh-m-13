package com.bluemoon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    
    // Hàm để mã hóa mật khẩu (Chuẩn)
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //Hàm này để tạm thời mở cửa toàn bộ API cho Frontend làm việc
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()) // Tắt CSRF để Postman và Frontend gửi lệnh POST/PUT không bị chặn
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll() // CHO PHÉP TẤT CẢ REQUEST TRUY CẬP MÀ KHÔNG CẦN TOKEN
            );
        return http.build();
    }
}
