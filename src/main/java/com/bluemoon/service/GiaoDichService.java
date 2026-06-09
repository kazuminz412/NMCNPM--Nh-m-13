package com.bluemoon.service;

import com.bluemoon.model.GiaoDich;
import com.bluemoon.model.HoaDon;
import com.bluemoon.repository.GiaoDichRepository;
import com.bluemoon.repository.HoaDonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GiaoDichService {

    private final GiaoDichRepository giaoDichRepo;
    private final HoaDonRepository hoaDonRepo; // Bắt buộc phải gọi Kho Hóa Đơn vào

    @Transactional
    public GiaoDich xacNhanThuTien(Long hoaDonId, Long soTienKhach, String phuongThuc, String ghiChu) {
        
        // 1. Tìm Hóa đơn cần thanh toán
        HoaDon hoaDon = hoaDonRepo.findById(hoaDonId)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy hóa đơn mã: " + hoaDonId));

        // 2. Chặn đứng nếu phát hiện hóa đơn này đã thu tiền rồi
        if ("da_thanh_toan".equals(hoaDon.getTrangThai())) {
            throw new IllegalStateException("Hóa đơn này đã được thanh toán trước đó!");
        }

        // 3. (Tùy chọn) Chặn nếu số tiền khách đưa ít hơn số tiền cần thu
        if (soTienKhach < hoaDon.getTongTien()) {
            throw new IllegalArgumentException("Khách đưa thiếu tiền! Cần thu: " + hoaDon.getTongTien());
        }

        // 4. Cập nhật trạng thái Hóa Đơn -> Đã thanh toán
        hoaDon.setTrangThai("da_thanh_toan");
        hoaDonRepo.save(hoaDon);

        // 5. Tạo mới tờ Biên Lai (Giao Dịch) để lưu lịch sử
        GiaoDich giaoDich = new GiaoDich();
        giaoDich.setMaGiaoDich("BL-" + System.currentTimeMillis()); // Sinh mã ngẫu nhiên VD: BL-1718123456
        giaoDich.setHoaDon(hoaDon);
        giaoDich.setHoDan(hoaDon.getHoDan()); // Lưu luôn ID Hộ dân để truy xuất cực nhanh cho Góc Cư Dân
        giaoDich.setSoTien(hoaDon.getTongTien()); // Chỉ ghi nhận số tiền thực tế của Hóa đơn vào doanh thu
        giaoDich.setPhuongThuc(phuongThuc);
        giaoDich.setThoiGian(LocalDateTime.now());
        giaoDich.setGhiChu(ghiChu);

        return giaoDichRepo.save(giaoDich);
    }
}
