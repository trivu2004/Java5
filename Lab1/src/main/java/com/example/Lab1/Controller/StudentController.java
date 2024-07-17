package com.example.Lab1.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

    @RequestMapping("/student/form")
    public String showForm(){

        return "/student-form.html";
    }
    @RequestMapping("/student/save")
    public String saveData(HttpServletRequest request, ModelMap model){
        String name = request.getParameter("name");
        String mark = request.getParameter("mark");
        String major = request.getParameter("major");
        model.addAttribute("NAME","Họ và Tên: "+name);
        model.addAttribute("MARK","Diem TB: "+mark);
        model.addAttribute("MAJOR","Chuyên ngành: "+major);
        return "/student-info.html";
    }
}
