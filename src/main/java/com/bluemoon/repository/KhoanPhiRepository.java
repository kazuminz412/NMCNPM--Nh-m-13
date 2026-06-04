package com.bluemoon.repository;

import com.bluemoon.model.KhoanPhi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhoanPhiRepository extends JpaRepository<KhoanPhi, Long> {
}
