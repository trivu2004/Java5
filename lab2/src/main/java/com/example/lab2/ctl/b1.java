package com.example.lab2.ctl;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class b1 {

    @RequestMapping("/ok")
    public String ok() {
        return "ok";
    }
    @RequestMapping("/ok1")
    public String m1(Model model) {
        model.addAttribute("ok","ok 1");
        return "ok";
    }
    @RequestMapping("/ok2")
    public String m2(Model model) {
        model.addAttribute("ok","ok 2");
        return "ok";
    }
    @RequestMapping("/ok3")
    public String m3(Model model) {
        model.addAttribute("ok","ok 3");
        return "ok";
    }
}


