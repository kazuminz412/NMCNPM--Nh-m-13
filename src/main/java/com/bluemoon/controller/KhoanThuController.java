package com.bluemoon.controller;

import com.bluemoon.model.KhoanThu;
import com.bluemoon.service.KhoanThuService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/danh-muc-phi") // Sửa lại cho khớp với Frontend
@RequiredArgsConstructor
public class KhoanThuController {

    private final KhoanThuService service;

    // 1. Thêm mới
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody KhoanThu khoanThu) {
        return ResponseEntity.ok(service.save(khoanThu));
    }

    // 2. Lấy danh sách
    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // 3. Sửa khoản phí (Dành cho nút ✏️ Sửa giá)
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody KhoanThu khoanThuMoi) {
        // Backend cần viết thêm hàm update() trong KhoanThuService
        KhoanThu updated = service.update(id, khoanThuMoi); 
        return ResponseEntity.ok(updated);
    }

    // 4. Xóa khoản phí (Dành cho nút 🗑 Xóa)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        // Backend cần viết thêm hàm delete() trong KhoanThuService
        service.delete(id);
        return ResponseEntity.ok("Xóa thành công!");
    }
}
