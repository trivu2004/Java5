package com.example.lab2.ctl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Bai2 {
    @RequestMapping("/param/form")
    public String form() {
        return "form";
    }
    @RequestMapping("/param/save/{x}")
    public String save(@PathVariable String x, @RequestParam String y) {
        // Xử lý logic ở đây nếu cần
        return "form";
    }
}
