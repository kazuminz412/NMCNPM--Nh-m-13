package com.bluemoon.controller;

import com.bluemoon.model.NhanKhau;
import com.bluemoon.service.NhanKhauService;
import jakarta.validation.Valid; 
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*") //. MỞ CỬA CHO FRONTEND GỌI API
@RestController
@RequestMapping("/api/nhan-khau") 
@RequiredArgsConstructor
public class NhanKhauController {
    
    private final NhanKhauService nhanKhauService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(nhanKhauService.findAll());
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody NhanKhau nhanKhau) { 
        return ResponseEntity.ok(nhanKhauService.save(nhanKhau));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody NhanKhau nhanKhau) {
        return ResponseEntity.ok(nhanKhauService.update(id, nhanKhau));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        nhanKhauService.delete(id);
        return ResponseEntity.ok("Đã xóa nhân khẩu thành công");
    }
}
