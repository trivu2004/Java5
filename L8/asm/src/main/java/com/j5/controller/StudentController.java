package com.j5.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.j5.bean.Student;

@Controller
public class StudentController {
	@RequestMapping("/student/form")
	public String form(@ModelAttribute("sv") Student sv) {
		return "student/form";
	}
	@RequestMapping("/student/save")
	public String save(Model model, @Validated @ModelAttribute("sv") Student sv, Errors errors) {
if(errors.hasErrors()) {
	model.addAttribute("message", "Vui lòng sửa các lỗi sau:");
} else {
	model.addAttribute("message", "Chúc mừng, bạn đã nhập đúng");
}
		return "student/form";
	}

@ModelAttribute("genders")
public Map<Boolean, String> getGenders(){
	Map<Boolean, String> map = new HashMap<>();
	map.put(true, "Male");
	map.put(false, "Female");
	return map;
}

@ModelAttribute("faculties")
public List<String> getFaculties(){
	return Arrays.asList("CNTT", "DLNHKS", "QTDN");
}

@ModelAttribute("hobbies")
public Map<String, String> getHobbies(){
	Map<String, String> map = new HashMap<>();
	map.put("T", "Travelling");
	map.put("M", "Music");
	map.put("F", "Food");
	map.put("O", "Other");
	return map;
}
}