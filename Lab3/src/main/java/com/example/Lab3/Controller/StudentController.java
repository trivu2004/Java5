package com.example.Lab3.Controller;

import com.example.Lab3.Model.Student;
import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@MultipartConfig
public class StudentController {
    @Autowired
    ServletContext app;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("form")
    public String bai1_form(@ModelAttribute("student") Student sv, Model model) {
        return "form";
    }

    @PostMapping("/form/save")
    public String bai1_save(@Validated @ModelAttribute("student") Student sv, BindingResult result, Model model, @RequestParam("image") MultipartFile file) throws IllegalStateException, IOException {
        if(!file.isEmpty()) {
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            // save the file on the local file system
            try {
                System.out.println(app.getRealPath(fileName));
                Path path = Paths.get(app.getRealPath(fileName));
                Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
                // System.out.print(path.toString());
                String dd=file.getOriginalFilename();

                if(result.hasErrors())
                    model.addAttribute("thongbao","ban phai dien dung thong tin");
                else
                {
                    model.addAttribute("dd",dd); // gọi ảnh ra bên form
                    model.addAttribute("svdk", sv); // hiển thị thông tin sv đăng ký bên form
                    model.addAttribute("thongbao","dang ky thanh cong");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "form";
    }

    @ModelAttribute("genders")
    public Map<Boolean, String> getGenders(){
        Map<Boolean, String> map = new HashMap<>();
        map.put(true, "Male");
        map.put(false, "Female");
        return map;
    }

    @ModelAttribute("listFaculty")
    public List<String> getFaculties(){
        return Arrays.asList("CNTT", "DLNHKS", "QTDN","UDPM");
    }

    @ModelAttribute("listHobbies")
    public Map<String, String> getHobbies(){
        Map<String, String> map = new HashMap<>();
        map.put("T", "Travelling");
        map.put("P", "Playgame");
        map.put("M", "Music");
        map.put("F", "Food");
        map.put("O", "Other");
        return map;
    }
}
