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
    // 1. Tìm Người dùng theo username
    NguoiDung NguoiDung = repository.findByUsername(username)
        .orElseThrow(() -> new RuntimeException("Sai tên đăng nhập hoặc mật khẩu!")); // Lỗi 401
    
    // 2. So sánh mật khẩu (password người dùng nhập vs password đã hash trong DB)
    if (!passwordEncoder.matches(password, user.getPassword())) {
        throw new RuntimeException("Sai tên đăng nhập hoặc mật khẩu!"); // Lỗi 401
    }
    
    // 3. Nếu đúng, trả về Token
    return jwtUtils.generateToken(user.getUsername());
}
    }

    // 2. REGISTER
    public void register(NguoiDung nguoiDung) {
        if (repository.existsByUsername(nguoiDung.getUsername())) {
            throw new RuntimeException("Tên đăng nhập này đã có người sử dụng!");
        }

        // Mã hóa mật khẩu
        nguoiDung.setPassword(passwordEncoder.encode(nguoiDung.getPassword()));
        
        // Gán quyền mặc định
        if (nguoiDung.getRole() == null || nguoiDung.getRole().isEmpty()) {
            nguoiDung.setRole("CU_DAN"); 
        }

        repository.save(nguoiDung);
    }
}
