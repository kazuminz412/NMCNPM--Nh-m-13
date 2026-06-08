package com.bluemoon.service;

import com.bluemoon.model.KhoanThu;
import com.bluemoon.repository.KhoanThuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class KhoanThuService {
    private final KhoanThuRepository repository;

    public KhoanThu save(KhoanThu khoanThu) {
        return repository.save(khoanThu);
    }

    public List<KhoanThu> findAll() {
        return repository.findAll();
    }
}
