package com.mcu.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    // Menampilkan halaman login user
    @GetMapping("/user-login")
    public String showUserLoginPage() {
        return "login-user"; // Pastikan template "login-user" ada di folder resources/templates
    }

    // Menangani form login user
    @PostMapping("/user-login")
    public String handleUserLogin(@RequestParam String username, @RequestParam String password, Model model) {
        // Validasi username dan password untuk login user
        if (username.equals("user") && password.equals("userpassword")) {
            return "redirect:/user-dashboard"; // Jika login berhasil, arahkan ke dashboard
        }

        // Jika login gagal, kembali ke halaman login dengan pesan error
        model.addAttribute("error", "Invalid username or password. Please try again.");
        return "login-user"; // Kembali ke halaman login dengan error message
    }
}
