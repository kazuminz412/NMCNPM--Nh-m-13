package com.bluemoon.repository;

import com.bluemoon.model.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, Long> {

    // 1. Tìm hóa đơn theo tháng (VD: "2026-05")
    List<HoaDon> findByThang(String thang);

    // 2. Tìm hóa đơn theo trạng thái (VD: "CHUA_THANH_TOAN")
    List<HoaDon> findByTrangThai(String trangThai);

    // 3. Kết hợp: Tìm hóa đơn theo tháng VÀ trạng thái (Rất cần cho bộ lọc giao diện)
    List<HoaDon> findByThangAndTrangThai(String thang, String trangThai);

    // 4. Tìm kiếm theo tên chủ hộ hoặc căn hộ (Sử dụng LIKE để tìm gần đúng)
    @Query("SELECT h FROM HoaDon h WHERE h.tenChuHo LIKE %:keyword% OR h.canHo LIKE %:keyword%")
    List<HoaDon> searchByKeyword(@Param("keyword") String keyword);

    // 5. Thống kê hóa đơn theo tháng (Đếm số hóa đơn chưa TT và đã TT)
    @Query("SELECT COUNT(h) FROM HoaDon h WHERE h.thang = :thang AND h.trangThai = :trangThai")
    long countByThangAndTrangThai(@Param("thang") String thang, @Param("trangThai") String trangThai);
}
