package com.mcu.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    @GetMapping("/admin-login")
    public String showAdminLoginPage() {
        return "login-admin"; // Tampilan login
    }

    @PostMapping("/admin-login")
    public String handleAdminLogin(@RequestParam String username, @RequestParam String password, Model model) {
        if (username.equals("admin") && password.equals("adminpassword")) {
            return "redirect:/admin-dashboard"; // Jika berhasil login, menuju ke dashboard
        }
        
        // Menambahkan pesan error ke model untuk ditampilkan di halaman login
        model.addAttribute("error", "Invalid username or password. Please try again.");
        return "login-admin"; // Jika gagal, kembali ke login dengan error
    }
}
