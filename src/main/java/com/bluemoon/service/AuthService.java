package com.bluemoon.service;

import com.bluemoon.model.User; 
import com.bluemoon.repository.UserRepository;
import com.bluemoon.security.JwtUtils; 
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    
    private final UserRepository repository; 
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    // 1. LOGIN
    public String login(String username, String password) {
        User user = repository.findByUsername(username) // Tìm theo username
            .filter(u -> passwordEncoder.matches(password, u.getPassword())) 
            .orElseThrow(() -> new RuntimeException("Sai tên đăng nhập hoặc mật khẩu!"));
        
        return jwtUtils.generateToken(user.getUsername());
    }

    // 2. REGISTER
    public void register(User user) {
        // Kiểm tra trùng lặp
        if (repository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Tên đăng nhập này đã có người sử dụng!");
        }

        // Mã hóa mật khẩu
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        
        // Gán quyền mặc định nếu chưa có
        if (user.getRole() == null) {
            user.setRole("CU_DAN"); 
        }

        repository.save(user);
    }
}
