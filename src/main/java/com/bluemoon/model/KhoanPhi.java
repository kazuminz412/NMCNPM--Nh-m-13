package com.bluemoon.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "khoan_phi")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class KhoanPhi extends BaseEntity {
    
    @Column(nullable = false)
    private String tenKhoanPhi;
    
    @Column(nullable = false)
    private String loaiPhi;
    
    @Column(nullable = false)
    private Double donGia;
    
    private String chuKy; 
}
