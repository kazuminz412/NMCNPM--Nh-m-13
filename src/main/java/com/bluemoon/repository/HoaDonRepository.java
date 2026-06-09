package com.bluemoon.repository;

import com.bluemoon.model.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, Long> {

    // 1. Chốt chặn bảo vệ: Kiểm tra xem tháng này đã chốt sổ hóa đơn chưa
    boolean existsByThang(String thang);

    // 2. Gọi Stored Procedure siêu tốc độ
    @Modifying
    @Transactional
    @Query(value = "CALL sp_TaoHoaDonDinhKy(:thang)", nativeQuery = true)
    void taoHoaDonDinhKy(@Param("thang") String thang);
}
