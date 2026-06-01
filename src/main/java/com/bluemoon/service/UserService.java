package com.bluemoon.service;

import com.bluemoon.model.User;
import com.bluemoon.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor // Tự động tạo constructor cho các biến final (Dependency Injection)
public class UserService {

    private final UserRepository userRepository;
    // 1.HÀM XÁC THỰC (ĐĂNG NHẬP)
    public User checkLogin(String username, String password) {
        return userRepository.findByUsername(username)
                .filter(user -> user.getPassword().equals(password))
                .orElse(null); // Trả về null nếu không tìm thấy hoặc sai mật khẩu
    }

    // 2. HÀM CRUD (QUẢN LÝ NGƯỜI DÙNG)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public User save(User user) {
        // Kiểm tra logic trước khi lưu
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Tên đăng nhập đã tồn tại trong hệ thống!");
        }
        return userRepository.save(user);
    }

    public User update(Long id, User userDetails) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Không tìm thấy người dùng với ID: " + id));
        
        // BỔ SUNG: Kiểm tra xem user có đổi tên không? Nếu có đổi thì tên mới đã tồn tại chưa?
        if (!user.getUsername().equals(userDetails.getUsername()) && 
            userRepository.existsByUsername(userDetails.getUsername())) {
            throw new RuntimeException("Tên đăng nhập mới đã có người sử dụng!");
        }
        
        user.setUsername(userDetails.getUsername());
        user.setEmail(userDetails.getEmail());
        
        // Cập nhật mật khẩu
        if(userDetails.getPassword() != null && !userDetails.getPassword().isEmpty()) {
            user.setPassword(userDetails.getPassword());
        }
        
        return userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
