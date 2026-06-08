package com.bluemoon.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;

@Entity
@Table(name = "khoan_thu")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class KhoanThu extends BaseEntity {

    @Column(nullable = false)
    private String tenKhoanThu;

    @Column(nullable = false)
    private String loaiPhi;

    @Min(value = 0, message = "Đơn giá không được phép là số âm!")
    @Column(nullable = false)
    private Double donGia;

    private String chuKy;
}
