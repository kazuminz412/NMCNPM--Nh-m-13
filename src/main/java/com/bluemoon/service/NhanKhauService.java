package com.bluemoon.service;

import com.bluemoon.model.NhanKhau;
import com.bluemoon.repository.NhanKhauRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NhanKhauService {
    private final NhanKhauRepository nhanKhauRepository;

    // Lấy danh sách toàn bộ nhân khẩu
    public List<NhanKhau> findAll() {
        return nhanKhauRepository.findAll();
    }

    // Thêm nhân khẩu mới
    public NhanKhau save(NhanKhau nhanKhau) {
        // Có thể thêm logic kiểm tra trùng CCCD ở đây
        return nhanKhauRepository.save(nhanKhau);
    }

    // Cập nhật thông tin nhân khẩu
    public NhanKhau update(Long id, NhanKhau details) {
        NhanKhau existing = nhanKhauRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Không tìm thấy nhân khẩu với ID: " + id));
        
        existing.setHoTen(details.getHoTen());
        existing.setNgaySinh(details.getNgaySinh());
        // ... các trường khác
        
        return nhanKhauRepository.save(existing);
    }

    // Xóa nhân khẩu
    public void delete(Long id) {
        nhanKhauRepository.deleteById(id);
    }
}
