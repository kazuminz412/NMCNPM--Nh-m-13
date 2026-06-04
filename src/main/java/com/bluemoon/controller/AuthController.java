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
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody com.bluemoon.model.NguoiDung nguoiDung) {
        try {
            authService.register(nguoiDung);
            return ResponseEntity.ok(Map.of("message", "Đăng ký thành công!"));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message", e.getMessage()));
        }
    }
}
