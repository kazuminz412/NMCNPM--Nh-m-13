package com.bluemoon.controller;

import com.bluemoon.model.KhoanThu;
import com.bluemoon.service.KhoanThuService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/khoan-thu")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class KhoanThuController {

    private final KhoanThuService service;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody KhoanThu khoanThu) {
        return ResponseEntity.ok(service.save(khoanThu));
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
