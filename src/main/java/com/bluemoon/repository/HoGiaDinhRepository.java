package com.bluemoon.repository;

import com.bluemoon.model.HoGiaDinh;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HoGiaDinhRepository extends JpaRepository<HoGiaDinh, Long> {
    boolean existsByMaHoKhau(String maHoKhau);
}
