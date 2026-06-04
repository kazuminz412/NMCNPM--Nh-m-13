package com.bluemoon.service;

import com.bluemoon.model.User; 
import com.bluemoon.repository.UserRepository; 
import com.bluemoon.security.JwtUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {

    // 1. Khai báo các đối tượng giả (Mocks)
    @Mock
    private UserRepository repository; 

    @Mock
    private BCryptPasswordEncoder passwordEncoder;

    @Mock
    private JwtUtils jwtUtils;

    // 2. Bơm các Mocks vào Service cần test
    @InjectMocks
    private AuthService authService;

    // KỊCH BẢN 1: ĐĂNG NHẬP THÀNH CÔNG
    @Test
    void testLogin_Success() {
        // Chuẩn bị dữ liệu giả
        User user = new User();
        user.setUsername("admin");
        user.setPassword("chuoi_ma_hoa_loang_ngoang"); // DB luôn lưu mật khẩu đã băm
        
        // Dạy cho các Mock biết phải làm gì
        when(repository.findByUsername("admin")).thenReturn(Optional.of(user));
        when(passwordEncoder.matches("123456", "chuoi_ma_hoa_loang_ngoang")).thenReturn(true);
        when(jwtUtils.generateToken("admin")).thenReturn("mocked-jwt-token-xyz");
        
        // Thực thi
        String resultToken = authService.login("admin", "123456");
        
        // Kiểm tra kết quả
        assertEquals("mocked-jwt-token-xyz", resultToken);
    }

    // KỊCH BẢN 2: NHẬP SAI MẬT KHẨU
    @Test
    void testLogin_WrongPassword_ThrowsException() {
        // Chuẩn bị
        User user = new User();
        user.setUsername("admin");
        user.setPassword("chuoi_ma_hoa_loang_ngoang");
        
        // Dạy cho Mock: Khi quét mật khẩu sai thì báo false
        when(repository.findByUsername("admin")).thenReturn(Optional.of(user));
        when(passwordEncoder.matches("sai_pass", "chuoi_ma_hoa_loang_ngoang")).thenReturn(false);
        
        // Thực thi và Kỳ vọng sẽ ném ra lỗi RuntimeException
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            authService.login("admin", "sai_pass");
        });
        
        // Kiểm tra câu thông báo lỗi xem có khớp không
        assertEquals("Sai tên đăng nhập hoặc mật khẩu!", exception.getMessage());
    }
}
