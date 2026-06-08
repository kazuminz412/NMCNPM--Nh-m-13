package com.bluemoon.repository;

import com.bluemoon.model.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, Long> {
    @Query(value = "CALL sp_TaoHoaDonDinhKy(:thangNam)", nativeQuery = true)
    void taoHoaDonDinhKy(@Param("thangNam") String thangNam);
}
