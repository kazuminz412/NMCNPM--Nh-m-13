package com.bluemoon.repository;

import com.bluemoon.model.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, Long> {

    List<HoaDon> findByThang(String thang);
    List<HoaDon> findByTrangThai(String trangThai);
    List<HoaDon> findByThangAndTrangThai(String thang, String trangThai);
    @Query("SELECT h FROM HoaDon h WHERE h.tenChuHo LIKE %:keyword% OR h.canHo LIKE %:keyword%")
    List<HoaDon> searchByKeyword(@Param("keyword") String keyword);
    @Query("SELECT COUNT(h) FROM HoaDon h WHERE h.thang = :thang AND h.trangThai = :trangThai")
    long countByThangAndTrangThai(@Param("thang") String thang, @Param("trangThai") String trangThai);
}
