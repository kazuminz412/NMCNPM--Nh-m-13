package com.bluemoon.controller;

import com.bluemoon.model.HoDan;
import com.bluemoon.service.HoDanService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*") // MỞ CỬA CHO FRONTEND GỌI API (CHỐNG LỖI CORS)
@RestController
@RequestMapping("/api/ho-dan") 
@RequiredArgsConstructor
public class HoDanController {
    
    private final HoDanService service;

    @GetMapping
    public ResponseEntity<?> getAll() { 
        return ResponseEntity.ok(service.getAll()); 
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody HoDan ho) {
        return ResponseEntity.ok(service.create(ho));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody HoDan ho) {
        return ResponseEntity.ok(service.update(id, ho));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Đã xóa hộ gia đình!");
    }
}
