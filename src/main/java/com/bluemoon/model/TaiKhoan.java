package com.bluemoon.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "tai_khoan")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class TaiKhoan extends BaseEntity {
    @Column(unique = true, nullable = false)
    private String username;
    
    @Column(nullable = false)
    private String password;
    
    private String role; 
    
    private Long hoDanId;
}
