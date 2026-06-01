package com.bluemoon.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class HoGiaDinh extends BaseEntity {
    private String soPhong;
    private String chuHo;
    private String soDienThoai;
}
