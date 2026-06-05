package com.bluemoon.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Table(name = "nhan_khau")
@Getter @Setter
public class NhanKhau extends BaseEntity {
    
    private String hoTen;
    
    @Column(name = "cccd")
    private String soCCCD;
    
    private LocalDate ngaySinh;
    
    private String gioiTinh;

    private String soDienThoai;
    
    @Column(name = "quan_he_chu_ho")
    private String quanHe;
    
    @Column(name = "trang_thai_cu_tru")
    private String trangThai; 
    
    private String ghiChu;
    @ManyToOne
    @JoinColumn(name = "ho_gia_dinh_id")
    private HoDan hoDan;

    @Transient 
    private Long hoDanId;
}
