package com.example.lab2.ctl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Pheptinh {
    @GetMapping("/pheptinh/form")
    public String dogetForm(){
        return "formTinh";
    }
    @RequestMapping("/ketqua")
    public String abc(){
        return "ketqua";
    }
    @GetMapping("/pheptinh")
    public String doGetPhepTinh(@RequestParam("a") int a, @RequestParam("b") int b, Model model){
        int ketqua = a+b;
        model.addAttribute("kq",ketqua);
        return "ketqua";
    }
    @PostMapping("/pheptinh")
    public String doGetPhepTinh1(@RequestParam("a") int a, @RequestParam("b") int b, Model model){
        int ketqua = a+b;
        model.addAttribute("kq",ketqua);
        return "forward:/ketqua";
    }
}
