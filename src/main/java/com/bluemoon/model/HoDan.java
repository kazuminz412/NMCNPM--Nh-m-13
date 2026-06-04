package com.bluemoon.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Getter @Setter
public class HoGiaDinh extends BaseEntity {
    
    private String maHoKhau;      
    private String soPhong;
    private String toaNha;
    private Double dienTichM2;
    private String tenChuHo;     
    private LocalDate ngayCapHoKhau;
    private String soDienThoai;  
    
}
