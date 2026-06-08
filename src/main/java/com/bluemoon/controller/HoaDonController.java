package com.bluemoon.controller;

import com.bluemoon.service.HoaDonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/hoa-don")
@RequiredArgsConstructor
public class HoaDonController {

    private final HoaDonService hoaDonService;

    @PostMapping("/tao-dinh-ky")
    public ResponseEntity<?> taoHoaDonDinhKy(@RequestParam String thangNam) {
        try {
            hoaDonService.taoHoaDonChoThang(thangNam);
            return ResponseEntity.ok(Map.of("message", "Đã tạo hóa đơn cho tháng " + thangNam + " thành công!"));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(Map.of("error", "Lỗi khi tạo hóa đơn: " + e.getMessage()));
        }
    }
}
