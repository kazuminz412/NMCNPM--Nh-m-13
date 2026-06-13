package com.bluemoon.controller;

import com.bluemoon.security.JwtUtils;
import com.bluemoon.service.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/me")
@RequiredArgsConstructor
public class MeController {

    private final JwtUtils jwtUtils;
    private final HoaDonService hoaDonService;
    private final PhuongTienService phuongTienService;
    private final NhanKhauService nhanKhauService;

    // Lấy token từ header, giải mã lấy hoDanId, rồi truy vấn dữ liệu tương ứng
    private Long getHoDanId(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        String jwt = authHeader.substring(7);
        return jwtUtils.extractHoDanId(jwt);
    }

    @GetMapping("/hoa-don")
    public ResponseEntity<?> getHoaDonCuaToi(HttpServletRequest request) {
        return ResponseEntity.ok(hoaDonService.findByHoDanId(getHoDanId(request)));
    }

    @GetMapping("/phuong-tien")
    public ResponseEntity<?> getPhuongTienCuaToi(HttpServletRequest request) {
        return ResponseEntity.ok(phuongTienService.findByHoDanId(getHoDanId(request)));
    }

    @GetMapping("/nhan-khau")
    public ResponseEntity<?> getNhanKhauCuaToi(HttpServletRequest request) {
        return ResponseEntity.ok(nhanKhauService.findByHoDanId(getHoDanId(request)));
    }
}
