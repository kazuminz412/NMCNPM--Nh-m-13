package com.bluemoon.service;

import com.bluemoon.repository.HoaDonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class HoaDonService {
    
    private final HoaDonRepository hoaDonRepository;

    @Transactional
    public void taoHoaDonChoThang(String thangNam) {
        hoaDonRepository.taoHoaDonDinhKy(thangNam);
    }
}
