package com.bluemoon.controller;

import com.bluemoon.model.HoaDon;
import com.bluemoon.service.HoaDonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hoa-don")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class HoaDonController {

    private final HoaDonService hoaDonService;

    // 1. TẠO HÓA ĐƠN ĐỊNH KỲ (Chỉ Admin hoặc Kế toán mới được quyền làm)
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_KE_TOAN')")
    @PostMapping("/tao-dinh-ky")
    public ResponseEntity<?> taoHoaDonThang(@RequestParam String thangNam) {
        try {
            hoaDonService.taoHoaDonDinhKy(thangNam);
            return ResponseEntity.ok("Đã khởi tạo thành công hóa đơn cho tháng: " + thangNam);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Lỗi: " + e.getMessage());
        }
    }

    // 2. LẤY DANH SÁCH HÓA ĐƠN THEO THÁNG
    @GetMapping
    public ResponseEntity<List<HoaDon>> getDanhSachHoaDon(@RequestParam String thangNam) {
        List<HoaDon> danhSach = hoaDonService.timKiemTheoThang(thangNam);
        return ResponseEntity.ok(danhSach);
    }

    // 3. XEM CHI TIẾT HÓA ĐƠN CỦA MỘT HỘ DÂN (Cư dân chỉ xem được hóa đơn của chính mình)
    @GetMapping("/{id}")
    public ResponseEntity<HoaDon> getChiTietHoaDon(@PathVariable Long id) {
        HoaDon hoaDon = hoaDonService.timTheoId(id);
        return ResponseEntity.ok(hoaDon);
    }

    // 4. XÓA HÓA ĐƠN (Chỉ Admin mới có quyền xóa nếu lỡ tạo sai)
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> xoaHoaDon(@PathVariable Long id) {
        hoaDonService.xoaHoaDon(id);
        return ResponseEntity.ok("Đã xóa hóa đơn thành công!");
    }
}
