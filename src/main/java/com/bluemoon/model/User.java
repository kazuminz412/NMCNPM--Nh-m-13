package com.bluemoon.model;

import com.fasterxml.jackson.annotation.JsonIgnore; // Import để dùng JsonIgnore
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "nguoi_dung")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity { 
    @Column(name = "ten_dang_nhap", nullable = false, unique = true, length = 50)
    private String username;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    
    @JsonIgnore 
    @Column(name = "mat_khau", nullable = false)
    private String password;

    @Column(name = "vai_tro", nullable = false)
    private String role; 

    @Column(name = "nhan_khau_id", unique = true)
    private Integer nhanKhauId; 
}
