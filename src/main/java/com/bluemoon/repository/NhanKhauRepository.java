package com.bluemoon.repository;

import com.bluemoon.model.NhanKhau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhanKhauRepository extends JpaRepository<NhanKhau, Long> {
    // Tìm nhân khẩu theo CCCD (hữu ích cho việc validate)
    boolean existsBySoCCCD(String soCCCD);
    
    // Tìm nhân khẩu theo ID hộ gia đình
    List<NhanKhau> findByHoDanId(Long hoDanId);
}
