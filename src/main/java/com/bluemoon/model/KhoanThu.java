package com.bluemoon.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;

@Entity
@Table(name = "khoan_thu")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class KhoanThu extends BaseEntity {

    @Column(name = "ten_khoan_thu", nullable = false)
    private String tenKhoanThu; // Khớp với Frontend (hoặc đổi thành tenPhi)

    @Column(name = "loai_phi", nullable = false)
    private String loaiPhi; // bat_buoc / tu_nguyen

    // Sửa Double thành Long để tránh sai số tiền tệ
    @Min(value = 0, message = "Đơn giá không được phép là số âm!")
    @Column(name = "don_gia", nullable = false)
    private Long donGia; 

    // Bổ sung các trường để khớp với Frontend
    @Column(name = "don_vi_tinh", nullable = false)
    private String donViTinh; // m2, xe, ho, nguoi

    @Column(name = "trang_thai")
    private String trangThai; // dang_ap_dung / tam_ngung

    @Column(name = "mo_ta", columnDefinition = "TEXT")
    private String moTa;

    @Column(name = "chu_ky")
    private String chuKy; // Có thể giữ lại nếu nhóm muốn dùng
}
