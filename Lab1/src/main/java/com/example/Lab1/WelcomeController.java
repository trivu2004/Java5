package com.example.Lab1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
    @RequestMapping("/")
    public String show(){
        return "/welcome.html";
    }
}
