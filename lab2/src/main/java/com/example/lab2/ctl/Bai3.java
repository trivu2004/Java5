package com.example.lab2.ctl;

import com.example.lab2.Model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Bai3 {
    @GetMapping("/product/form")
    public String form(Model model) {
        model.addAttribute("product", new Product());
        return "Bai3";
    }

    @PostMapping("/product/save")
    public String save(@ModelAttribute Product product) {
        return "Bai3";
    }
}