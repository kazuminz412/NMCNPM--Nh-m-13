package com.bluemoon.repository;

import com.bluemoon.model.KhoanThu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhoanThuRepository extends JpaRepository<KhoanThu, Long> {
}
