package com.bluemoon.service;

import com.bluemoon.model.NguoiDung;
import com.bluemoon.repository.NguoiDungRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NguoiDungService {
    private final NguoiDungRepository nguoiDungRepository;
    private final PasswordEncoder passwordEncoder;

    public NguoiDung registerNguoiDung(NguoiDung nguoiDung) {
        if (nguoiDungRepository.existsByUsername(nguoiDung.getUsername())) {
            throw new RuntimeException("Tên đăng nhập đã tồn tại!");
        }
        nguoiDung.setPassword(passwordEncoder.encode(nguoiDung.getPassword()));
        return nguoiDungRepository.save(nguoiDung);
    }

    public Optional<NguoiDung> findByUsername(String username) {
        return nguoiDungRepository.findByUsername(username);
    }
}
