package com.bluemoon.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "giao_dich")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class GiaoDich extends BaseEntity {

    @Column(nullable = false)
    private Long hoaDonId;

    @Column(nullable = false)
    private Double soTien;

    @Column(nullable = false)
    private String phuongThuc; 

    @Column(nullable = false)
    private LocalDateTime thoiGian;

    private String ghiChu;
}
