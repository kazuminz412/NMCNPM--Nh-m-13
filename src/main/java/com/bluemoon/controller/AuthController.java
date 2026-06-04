package com.bluemoon.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:3000"})
public class AuthController {

    /**
     * POST /api/auth/login
     * Endpoint đăng nhập tạm thời (sau sẽ kết nối với Database)
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");

        // TODO: Thay thế bằng logic xác thực từ Database
        if ("admin".equals(username) && "123456".equals(password)) {
            return ResponseEntity.ok(Map.of(
                "token", "demo-token-" + System.currentTimeMillis(),
                "user", Map.of(
                    "id", 1,
                    "username", "admin",
                    "role", "TO_TRUONG"
                )
            ));
        }

        return ResponseEntity.status(401).body(Map.of(
            "message", "Tên đăng nhập hoặc mật khẩu không đúng!"
        ));
    }

    /**
     * GET /api/auth/health
     * Kiểm tra server có chạy không
     */
    @GetMapping("/health")
    public ResponseEntity<?> health() {
        return ResponseEntity.ok(Map.of(
            "status", "OK",
            "message", "Server is running"
        ));
    }
}