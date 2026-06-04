package com.bluemoon.controller;

import com.bluemoon.dto.LoginRequest;
import com.bluemoon.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*") // Cho phép frontend gọi API
public class AuthController {

    private final AuthService authService;

    // 1. ĐĂNG NHẬP
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            String token = authService.login(loginRequest.getUsername(), loginRequest.getPassword());
            // Trả về token cho frontend lưu vào localStorage
            return ResponseEntity.ok(Map.of("token", token));
        } catch (RuntimeException e) {
            // Trả về lỗi 401 nếu sai pass hoặc user
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", e.getMessage()));
        }
    }

    // 2. ĐĂNG KÝ
    @PostMapping("/login")
public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
    try {
        String token = authService.login(loginRequest.getUsername(), loginRequest.getPassword());
        
        // Trả về Token kèm thông tin cần thiết
        return ResponseEntity.ok(Map.of("token", token));
        
    } catch (RuntimeException e) {
        // Trả về 401 Unauthorized kèm thông báo lỗi
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                             .body(Map.of("message", e.getMessage()));
    }
}
}
