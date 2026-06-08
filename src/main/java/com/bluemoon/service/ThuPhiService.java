package com.bluemoon.service;

import com.bluemoon.model.GiaoDich;
import com.bluemoon.model.HoaDon;
import com.bluemoon.repository.GiaoDichRepository;
import com.bluemoon.repository.HoaDonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ThuPhiService {

    private final HoaDonRepository hoaDonRepository;
    private final GiaoDichRepository giaoDichRepository;

    @Transactional
    public void xacNhanThuTien(Long hoaDonId, Double soTien, String phuongThuc) {
        // 1. Tìm hóa đơn
        HoaDon hoaDon = hoaDonRepository.findById(hoaDonId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy hóa đơn!"));

        // 2. Lưu lịch sử giao dịch
        GiaoDich gd = new GiaoDich();
        gd.setHoaDonId(hoaDonId);
        gd.setSoTien(soTien);
        gd.setPhuongThuc(phuongThuc);
        gd.setThoiGian(LocalDateTime.now());
        giaoDichRepository.save(gd);

        // 3. Cập nhật trạng thái hóa đơn
        hoaDon.setTrangThai("DA_THANH_TOAN");
        hoaDonRepository.save(hoaDon);
        
    }
}
