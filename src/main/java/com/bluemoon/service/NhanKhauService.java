package com.bluemoon.service;

import com.bluemoon.model.HoGiaDinh;
import com.bluemoon.model.NhanKhau;
import com.bluemoon.repository.HoGiaDinhRepository;
import com.bluemoon.repository.NhanKhauRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NhanKhauService {
    
    private final NhanKhauRepository nhanKhauRepository;
    private final HoGiaDinhRepository hoGiaDinhRepository; 

    public List<NhanKhau> findAll() {
        return nhanKhauRepository.findAll();
    }

    // Thêm nhân khẩu mới
    public NhanKhau save(NhanKhau nhanKhau) {
        //  Kiểm tra trùng CCCD (Nếu người dùng có nhập CCCD)
        if (nhanKhau.getSoCCCD() != null && !nhanKhau.getSoCCCD().isEmpty()) {
            if (nhanKhauRepository.existsBySoCCCD(nhanKhau.getSoCCCD())) {
                throw new RuntimeException("Số CCCD này đã tồn tại trong hệ thống!");
            }
        }

        if (nhanKhau.getHoDanId() != null) {
            HoGiaDinh hoGiaDinh = hoGiaDinhRepository.findById(nhanKhau.getHoDanId())
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy Hộ gia đình để thêm vào!"));
            nhanKhau.setHoGiaDinh(hoGiaDinh);
        } else {
            throw new RuntimeException("Phải chọn Hộ gia đình cho nhân khẩu này!");
        }

        return nhanKhauRepository.save(nhanKhau);
    }

    public NhanKhau update(Long id, NhanKhau details) {
        NhanKhau existing = nhanKhauRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Không tìm thấy nhân khẩu với ID: " + id));
        
        if (details.getSoCCCD() != null && !details.getSoCCCD().equals(existing.getSoCCCD())) {
            if (nhanKhauRepository.existsBySoCCCD(details.getSoCCCD())) {
                throw new RuntimeException("Số CCCD mới đã bị trùng với người khác!");
            }
        }

        existing.setHoTen(details.getHoTen());
        existing.setNgaySinh(details.getNgaySinh());
        existing.setGioiTinh(details.getGioiTinh());
        existing.setSoCCCD(details.getSoCCCD());
        existing.setSoDienThoai(details.getSoDienThoai());
        existing.setQuanHe(details.getQuanHe());
        existing.setTrangThai(details.getTrangThai());
        existing.setGhiChu(details.getGhiChu());

        if (details.getHoDanId() != null && 
           (existing.getHoGiaDinh() == null || !existing.getHoGiaDinh().getId().equals(details.getHoDanId()))) {
            HoGiaDinh hoGiaDinhMoi = hoGiaDinhRepository.findById(details.getHoDanId())
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy Hộ gia đình mới!"));
            existing.setHoGiaDinh(hoGiaDinhMoi);
        }
        
        return nhanKhauRepository.save(existing);
    }

    // Xóa nhân khẩu
    public void delete(Long id) {
        nhanKhauRepository.deleteById(id);
    }
}
