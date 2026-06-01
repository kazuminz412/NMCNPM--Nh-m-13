package com.bluemoon.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "nguoi_dung") // Khớp chính xác với tên bảng trong MySQL
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseModel { // Kế thừa BaseModel để có sẵn ID và ngày tạo

    // Ánh xạ biến username với cột ten_dang_nhap
    @Column(name = "ten_dang_nhap", nullable = false, unique = true, length = 50)
    private String username;

    // Ánh xạ biến password với cột mat_khau
    @Column(name = "mat_khau", nullable = false)
    private String password;

    // Ánh xạ biến role với cột vai_tro trong Database
    @Column(name = "vai_tro", nullable = false)
    private String role; 

    // Ánh xạ với cột khóa ngoại nhan_khau_id (Cho phép null nếu là tài khoản Admin)
    @Column(name = "nhan_khau_id", unique = true)
    private Integer nhanKhauId; 
}

@JsonIgnore // Thêm dòng này để giấu mật khẩu khi gửi JSON về Frontend
    @Column(name = "mat_khau", nullable = false)
    private String password;
