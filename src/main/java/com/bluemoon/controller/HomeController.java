package com.bluemoon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    /**
     * GET /
     * Redirect tới login.html
     */
    @GetMapping("/")
    public String home() {
        return "redirect:/Frontend/login.html";
    }
}