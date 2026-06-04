package com.bluemoon.service;

import com.bluemoon.model.KhoanPhi;
import com.bluemoon.repository.KhoanPhiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class KhoanPhiService {
    private final KhoanPhiRepository repository;

    public KhoanPhi save(KhoanPhi khoanPhi) {
        // Logic kiểm tra đơn giá không được âm
        if (khoanPhi.getDonGia() == null || khoanPhi.getDonGia() < 0) {
            throw new IllegalArgumentException("Đơn giá không được phép là số âm!");
        }
        return repository.save(khoanPhi);
    }

    public List<KhoanPhi> findAll() {
        return repository.findAll();
    }
}
