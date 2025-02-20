package com.example.lab4.controller;

import com.example.lab4.service.CookieService;
import com.example.lab4.service.ParamService;
import com.example.lab4.service.SessionService;
import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@MultipartConfig
public class LoginController {
    @Autowired
    CookieService cookieService;
    @Autowired
    ParamService paramService;
    @Autowired
    SessionService sessionService;
    @Autowired
    HttpServletRequest request;
    @Autowired
    ServletContext app;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/login")
    public String login_index(Model model) {
        model.addAttribute("username", cookieService.getValue("username"));
        model.addAttribute("password", cookieService.getValue("password"));
        return "login";
    }

    @PostMapping("/login/user")
    public String login(@RequestParam(name = "file", required = false) MultipartFile file, Model model) {
        String username = paramService.getString("username", "");
        String password = paramService.getString("password", "");
        boolean remember = paramService.getBoolean("remember", false);
        if(username.equals("tri") && password.equals("123")) {
            sessionService.set("username", username);
            if(remember) {
                cookieService.add("username", username, 1);
                cookieService.add("password", password, 1);
                model.addAttribute("username", cookieService.getValue("username"));
                model.addAttribute("password", cookieService.getValue("password"));
            }
            else {
                cookieService.remove("username");
                cookieService.remove("password");
            }
            if(file != null) {
                try {
//					paramService.save(file, "D:\\");
                    paramService.save(file, app.getRealPath("E:\\Java5\\lab4\\src\\main\\resources\\static\\upload\\"));
                    model.addAttribute("anhupload",file.getOriginalFilename());
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return "login";
    }
}
