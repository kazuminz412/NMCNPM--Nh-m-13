package com.bluemoon.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "phuong_tien")
@Getter @Setter
public class PhuongTien extends BaseEntity {

    private String bienSo;      
    private String loaiXe;     
    private String mauXe;       
    
    // Mối quan hệ
    @ManyToOne
    @JoinColumn(name = "ho_gia_dinh_id")
    private HoGiaDinh hoGiaDinh;
}
