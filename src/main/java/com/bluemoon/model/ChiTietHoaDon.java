package com.bluemoon.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "chi_tiet_hoa_don")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class ChiTietHoaDon extends BaseEntity {

    private Long hoaDonId;
    private Long khoanThuId;
    private Integer soLuong;
    
    private Double thanhTien;
}
