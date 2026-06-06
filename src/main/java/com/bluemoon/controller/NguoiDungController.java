package com.bluemoon.controller;

import com.bluemoon.model.NguoiDung;
import com.bluemoon.service.NguoiDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nguoi-dung")
@CrossOrigin(origins = "*") // Cho phép Frontend kết nối
public class NguoiDungController {

    @Autowired
    private NguoiDungService nguoiDungService;

    // 1. Lấy danh sách tất cả cư dân
    @GetMapping
    public List<NguoiDung> getAllNguoiDung() {
        return nguoiDungService.findAll();
    }

    // 2. Thêm mới một cư dân vào hộ dân (hoDanId)
    @PostMapping("/them/{hoDanId}")
    public ResponseEntity<?> themNguoiDung(@RequestBody NguoiDung nguoiDung, @PathVariable Long hoDanId) {
        try {
            NguoiDung savedUser = nguoiDungService.themNguoiDung(nguoiDung, hoDanId);
            return ResponseEntity.ok(savedUser);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // 3. Cập nhật thông tin cư dân
    @PutMapping("/{id}")
    public ResponseEntity<NguoiDung> updateNguoiDung(@PathVariable Long id, @RequestBody NguoiDung nguoiDungDetails) {
        return ResponseEntity.ok(nguoiDungService.update(id, nguoiDungDetails));
    }

    // 4. Xóa cư dân
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNguoiDung(@PathVariable Long id) {
        nguoiDungService.delete(id);
        return ResponseEntity.ok("Đã xóa cư dân thành công!");
    }
}
