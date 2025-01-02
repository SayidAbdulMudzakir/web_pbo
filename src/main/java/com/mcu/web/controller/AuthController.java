package com.mcu.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    // Halaman login
    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Menampilkan halaman login
    }

    // Menangani login
    @PostMapping("/login")
    public String handleLogin(@RequestParam String username, @RequestParam String password) {
        if (username.equals("admin") && password.equals("password")) {
            return "redirect:/dashboard"; // Redirect ke dashboard jika login berhasil
        }
        return "login"; // Kembali ke halaman login jika login gagal
    }
}
