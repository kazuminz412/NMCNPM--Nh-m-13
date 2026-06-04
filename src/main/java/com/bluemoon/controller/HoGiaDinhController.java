package com.bluemoon.controller;

import com.bluemoon.model.HoGiaDinh;
import com.bluemoon.service.HoGiaDinhService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hogiadinh")
@RequiredArgsConstructor
public class HoGiaDinhController {
    private final HoGiaDinhService service;

    @GetMapping
    public ResponseEntity<?> getAll() { return ResponseEntity.ok(service.getAll()); }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody HoGiaDinh ho) {
        return ResponseEntity.ok(service.create(ho));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody HoGiaDinh ho) {
        return ResponseEntity.ok(service.update(id, ho));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Đã xóa hộ gia đình!");
    }
}
