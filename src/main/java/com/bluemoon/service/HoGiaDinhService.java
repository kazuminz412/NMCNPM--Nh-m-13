package com.bluemoon.service;

import com.bluemoon.model.HoGiaDinh;
import com.bluemoon.repository.HoGiaDinhRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HoGiaDinhService {
    private final HoGiaDinhRepository repo;

    public List<HoGiaDinh> getAll() { return repo.findAll(); }

    public HoGiaDinh create(HoGiaDinh ho) {
        if (repo.existsByMaHoKhau(ho.getMaHoKhau())) 
            throw new RuntimeException("Mã hộ khẩu đã tồn tại!");
        return repo.save(ho);
    }

    public HoGiaDinh update(Long id, HoGiaDinh data) {
        HoGiaDinh existing = repo.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy hộ"));
        existing.setMaHoKhau(data.getMaHoKhau());
        existing.setChuHo(data.getChuHo());
        return repo.save(existing);
    }

    public void delete(Long id) { repo.deleteById(id); }
}
