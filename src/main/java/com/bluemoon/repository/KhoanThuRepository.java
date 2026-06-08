package com.bluemoon.repository;

import com.bluemoon.model.KhoanThu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KhoanThuRepository extends JpaRepository<KhoanThu, Long> {

    // 1. Dùng cho luồng KHỞI TẠO HÓA ĐƠN:
    // Lọc ra các loại phí theo loại (VD: "bat_buoc") và trạng thái (VD: "dang_ap_dung")
    List<KhoanThu> findByLoaiPhiAndTrangThai(String loaiPhi, String trangThai);

    // 2. Dùng cho luồng THÊM KHOẢN PHÍ (Validation):
    // Kiểm tra xem tên khoản phí đã tồn tại chưa để tránh tạo trùng (VD: có 2 phí "Gửi xe máy")
    boolean existsByTenKhoanThu(String tenKhoanThu);
}
