package com.bluemoon.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing // Giúp tự động quản lý createdAt/updatedAt
public class DatabaseConfig {
  
}
