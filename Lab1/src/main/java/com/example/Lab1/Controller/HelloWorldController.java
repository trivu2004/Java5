package com.example.Lab1.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HelloWorldController {

//    @RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping("/")
    public String showHello1(){
        return "/helloworld.html";
    }
//    @RequestMapping("/hello")
    @PostMapping("/hello")
    public String showHello(){
        return "/helloworld.html";
    }
    @GetMapping("/helloName")
    public String helloName(){
        return "/helloworld.html";
    }
    @GetMapping("/display")
    public String displayName(HttpServletRequest request){
        String name = request.getParameter("name");
        System.out.println(name);
        request.setAttribute("NAME",name);
        return "/display.html";
    }
}
