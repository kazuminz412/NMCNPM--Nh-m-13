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
public class User extends BaseEntity { // Đổi thành BaseEntity cho khớp với file bạn ấy đã tạo

    @Column(name = "ten_dang_nhap", nullable = false, unique = true, length = 50)
    private String username;

    @JsonIgnore // Chỉ khai báo 1 lần password ở đây
    @Column(name = "mat_khau", nullable = false)
    private String password;

    @Column(name = "vai_tro", nullable = false)
    private String role; 

    @Column(name = "nhan_khau_id", unique = true)
    private Integer nhanKhauId; 
}
