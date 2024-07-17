package com.example.lab2.ctl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Bai5 {
    @RequestMapping("/a")
    public String m1() {
        return "a";
    }

    @RequestMapping("/b")
    public String m2(Model model) {
        model.addAttribute("message", "I come from b");
        return "a";
    }

    @RequestMapping("/c")
    public String m3(Model model) {
        model.addAttribute("message", "I come from c");
        return "a";
    }

    @RequestMapping("/d")
    public String m4(Model model) {
        model.addAttribute("message", "I come from d");
        return "a";
    }
}
