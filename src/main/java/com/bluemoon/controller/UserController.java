package com.bluemoon.controller;

import com.bluemoon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String getAllUsers() {
        return "Trả về danh sách người dùng từ Service";
    }
}
