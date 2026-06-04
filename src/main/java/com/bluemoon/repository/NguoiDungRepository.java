package com.bluemoon.repository;

import com.bluemoon.model.NguoiDung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    // Tìm kiếm user theo username
    Optional<User> findByUsername(String username);
    
    // Kiểm tra username đã tồn tại chưa
    boolean existsByUsername(String username);
}
