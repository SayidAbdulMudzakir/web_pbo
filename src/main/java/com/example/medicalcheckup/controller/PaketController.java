package com.example.medicalcheckup.controller;

import com.example.medicalcheckup.model.Paket; // Import the Paket model class
import com.example.medicalcheckup.service.PaketService; // Import the service to fetch pakets
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class PaketController {

    @Autowired
    private PaketService paketService; // Service to fetch the list of paket-mcus

    // Display the list of Paket MCU
    @GetMapping("/paket-mcu")
    public String listPakets(Model model) {
        model.addAttribute("pakets", paketService.getAllPakets()); // Add the pakets to the model
        return "paket-mcu"; // Return the Thymeleaf template
    }

    // Handle the Edit Paket action
    @GetMapping("/paket-mcu/edit/{id}")
    public String editPaket(@PathVariable Long id, Model model) {
        Paket paket = paketService.getPaketById(id);
        model.addAttribute("paket", paket);
        return "edit-paket"; // Render the edit form template
    }

    // Handle Delete Paket action
    @PostMapping("/paket-mcu/delete/{id}")
    public String deletePaket(@PathVariable Long id) {
        paketService.deletePaket(id); // Delete the paket
        return "redirect:/paket-mcu"; // Redirect back to the list
    }
}
