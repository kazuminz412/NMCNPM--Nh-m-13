package com.bluemoon.repository;

import com.bluemoon.model.User; // Giả sử bạn đã có model User
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Các hàm truy vấn DB cơ bản đã có sẵn trong JpaRepository
}
