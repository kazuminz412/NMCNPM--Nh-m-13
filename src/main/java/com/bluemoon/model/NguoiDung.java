package com.bluemoon.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "nguoi_dung")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class NguoiDung extends BaseEntity {

    @Column(name = "ten_dang_nhap", nullable = false, unique = true, length = 50)
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "mat_khau", nullable = false)
    private String password;

    @Column(name = "vai_tro", nullable = false)
    private String role; 

    @Column(name = "nhan_khau_id", unique = true)
    private Integer nhanKhauId; 
}
