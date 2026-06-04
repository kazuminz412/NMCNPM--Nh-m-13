package com.bluemoon.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min; // Import thư viện này
import lombok.*;

@Entity
@Table(name = "khoan_phi")
@Getter @Setter
public class KhoanPhi extends BaseEntity {
    
    @Column(nullable = false)
    private String tenKhoanPhi;
    
    @Column(nullable = false)
    private String loaiPhi;
    
    @Min(value = 0, message = "Đơn giá không được phép là số âm!")
    @Column(nullable = false)
    private Double donGia;
    
    private String chuKy;
}
