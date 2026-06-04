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
    private String soCCCD;
    private LocalDate ngaySinh;
    private String gioiTinh;
    
    @ManyToOne
    @JoinColumn(name = "ho_gia_dinh_id")
    private HoGiaDinh hoGiaDinh;
}
