package com.bluemoon.controller;

import com.bluemoon.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/thong-ke")
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ROLE_ADMIN')") // Chỉ Admin mới được xem thống kê
public class ThongKeController {

    private final GiaoDichRepository GiaoDichRepository;
    private final HoaDonRepository HoaDonRepository;
    private final HoDanRepository HoDanRepository;

    @GetMapping("/doanh-thu")
    public ResponseEntity<?> getDoanhThu() {
        return ResponseEntity.ok(Map.of("tongDoanhThu", GiaoDichRepository.tinhTongDoanhThuThangHienTai()));
    }

    @GetMapping("/cong-no")
    public ResponseEntity<?> getCongNo() {
        Object[] result = HoaDonRepository.tinhCongNo().get(0);
        return ResponseEntity.ok(Map.of("soLuongHoaDonNo", result[0], "tongTienNo", result[1]));
    }

    @GetMapping("/dan-cu")
    public ResponseEntity<?> getDanCu() {
        return ResponseEntity.ok(Map.of(
            "tongHoDan", HoDanRepository.demTongSoHoDan(),
            "tongNhanKhau", HoDanRepository.demTongNhanKhau(),
            "phuongTien", HoDanRepository.thongKePhuongTien()
        ));
    }
}
