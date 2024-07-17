package com.example.demo;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileOutputStream;

import com.example.demo.DAO.AccountDAO;

import com.example.demo.model.Account;

@Controller
public class account_Controller {

	@Autowired
	AccountDAO dao;

	@RequestMapping("/admin/account")
	public String index(Model model) {
		Account item = new Account();
		model.addAttribute("item", item);
		List<Account> items = dao.findAll();
		model.addAttribute("items", items);
		return "admin/account";
	}

	@RequestMapping("/account/edit/{username}")
	public String edit(Model model, @PathVariable("username") String username) {
		Account item = dao.findById(username).get();
		model.addAttribute("item", item);
		List<Account> items = dao.findAll();
		model.addAttribute("items", items);
		return "/admin/account";
	}

	@RequestMapping("/account/create")
	public String create(@Validated Account item, BindingResult errors,
			@RequestParam("photoFile") MultipartFile photoFile, Model model) {
//		if (errors.hasErrors()) { // Xử lý khi có lỗi
//			model.addAttribute("message", "Vui long sua cai loi sau:");
//		} else {
		if (!photoFile.isEmpty()) {
			try {

				String uploadDir = "D:\\JAVA5-SOF3021\\DeadLine\\ASM2\\src\\main\\webapp\\img\\ss";

				File directory = new File(uploadDir);
				if (!directory.exists()) {
					directory.mkdirs();
				}

				String fileName = System.currentTimeMillis() + "_" + photoFile.getOriginalFilename();
				String filePath = uploadDir + fileName;
				FileOutputStream fos = new FileOutputStream(filePath);
				fos.write(photoFile.getBytes());
				fos.close();
				item.setPhoto(fileName);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		dao.save(item);
//		}
		return "redirect:/admin/account";
	}

	@RequestMapping("/account/update")
	public String update(Account item, @RequestParam("photoFile") MultipartFile photoFile) {
		if (!photoFile.isEmpty()) {
			try {
				String uploadDir = "D:\\JAVA5-SOF3021\\DeadLine\\ASM2\\src\\main\\webapp\\img\\ss";

				File directory = new File(uploadDir);
				if (!directory.exists()) {
					directory.mkdirs();
				}

				String originalFileName = photoFile.getOriginalFilename();
				// Lấy phần tên của tệp tin mà không lấy số đầu
				String fileName = originalFileName.substring(originalFileName.indexOf("_") + 1);

				String filePath = uploadDir + "\\" + fileName;
				FileOutputStream fos = new FileOutputStream(filePath);
				fos.write(photoFile.getBytes());
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		dao.save(item);
		return "redirect:/account/edit/" + item.getUsername();
	}

	@RequestMapping("/account/delete/{username}")
	public String delete(@PathVariable("username") String id) {
		dao.deleteById(id);
		return "redirect:/admin/account";
	}

	@ModelAttribute("admin")
	public Map<Boolean, String> getGender() {
		Map<Boolean, String> map = new HashMap<>();
		map.put(true, "Admin");
		map.put(false, "User");
		return map;
	}

	@ModelAttribute("activated")
	public Map<Boolean, String> activated() {
		Map<Boolean, String> map = new HashMap<>();
		map.put(true, "Activation");
		map.put(false, " No Activation");
		return map;
	}

}
