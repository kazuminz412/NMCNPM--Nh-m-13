package com.bluemoon.service;

import com.bluemoon.model.NguoiDung; 
import com.bluemoon.repository.NguoiDungRepository;
import com.bluemoon.security.JwtUtils; 
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    
    private final NguoiDungRepository repository; 
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    // 1. LOGIN
    public String login(String username, String password) {
        NguoiDung user = repository.findByUsername(username)
            .orElseThrow(() -> new RuntimeException("Sai tên đăng nhập hoặc mật khẩu!"));
    
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Sai tên đăng nhập hoặc mật khẩu!");
        }
    
        return jwtUtils.generateToken(user.getUsername(), user.getRole());
    }

    // 2. REGISTER
    public void register(NguoiDung nguoiDung) {
        if (repository.existsByUsername(nguoiDung.getUsername())) {
            throw new RuntimeException("Tên đăng nhập này đã có người sử dụng!");
        }

        nguoiDung.setPassword(passwordEncoder.encode(nguoiDung.getPassword()));
        

        String role = nguoiDung.getRole();
        if (role == null || role.isEmpty()) {
            nguoiDung.setRole("ROLE_CU_DAN"); 
        } else if (!role.startsWith("ROLE_")) {
            nguoiDung.setRole("ROLE_" + role.toUpperCase());
        }

        repository.save(nguoiDung);
    }
}
