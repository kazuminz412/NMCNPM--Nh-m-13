package com.bluemoon.controller;

import com.bluemoon.model.User;
import com.bluemoon.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*") 
@RequiredArgsConstructor // Constructor Injection (Best Practice)
public class UserController {

    private final UserService userService;

    //  Đăng nhập
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginRequest) {
        User user = userService.checkLogin(loginRequest.getUsername(), loginRequest.getPassword());
        if (user != null) {
            // Đóng gói dữ liệu thành chuẩn { "token": "...", "user": {...} }
            Map<String, Object> response = new HashMap<>();
            response.put("token", "fake-jwt-token-cho-sprint1"); // Sprint 1 tạm dùng token giả
            response.put("user", user);
            
            return ResponseEntity.ok(response); 
        }
        
        // Frontend cũng đang chờ chữ "message" khi báo lỗi
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("message", "Sai tên đăng nhập hoặc mật khẩu!");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
    }

    // danh sách người dùng
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    // thông tin theo ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        return userService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("User không tồn tại"));
    }

    // Thêm mới
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // Cập nhật
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        try {
            return ResponseEntity.ok(userService.update(id, userDetails));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // Xóa
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.ok("Xóa người dùng thành công");
    }
}
