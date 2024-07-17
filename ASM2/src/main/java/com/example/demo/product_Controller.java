package com.example.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.DAO.AccountDAO;
import com.example.demo.DAO.CategoryDAO;
import com.example.demo.DAO.ProductDAO;
import com.example.demo.model.Account;
import com.example.demo.model.Category;
import com.example.demo.model.Product;

@Controller
public class product_Controller {

	@Autowired
	ProductDAO dao;
	@Autowired
	CategoryDAO catdao;

	@RequestMapping("/product")
	public String index(Model model) {
		Product item = new Product();
		model.addAttribute("item", item);
		List<Product> items = dao.findAll();
		model.addAttribute("list", catdao.findAll());
		model.addAttribute("items", items);
		return "admin/product";
	}

	@RequestMapping("/product/edit/{id}")
	public String edit(Model model, @PathVariable("id") Integer id) {
		Product item = dao.findById(id).get();
		model.addAttribute("item", item);
		List<Product> items = dao.findAll();
		model.addAttribute("items", items);
		return "admin/product";
	}

	int MAX_PATH_LENGTH = 255;

	// Trong phương thức create của product_Controller.java:
	@RequestMapping("/product/create")
	public String create(Product item, @RequestParam("photoFile") MultipartFile photoFile) {
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

				item.setImage(fileName);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Date ndate = new Date();
		item.setCreateDate(ndate);
		dao.save(item);
		return "redirect:/product";
	}

//	<form:select path="category">
//		<c:forEach var="item" items="${list}">
//			<form:option value="${item.id}">${item.name}</form:option>
//		</c:forEach>
//	</form:select>

	@RequestMapping("/product/update")
	public String update(Product item, @RequestParam("photoFile") MultipartFile photoFile) {
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

				item.setImage(fileName);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Date ndate = new Date();
		item.setCreateDate(ndate);
		dao.save(item);
		return "redirect:/product/edit/" + item.getId();
	}

	@RequestMapping("/product/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		dao.deleteById(id);
		return "redirect:/product";
	}

//	@ModelAttribute("admin")
//	public Map<Boolean, String> getGender() {
//		Map<Boolean, String> map = new HashMap<>();
//		map.put(true, "Admin");
//		map.put(false, "User");
//		return map;
//	}
//
	@ModelAttribute("available")
	public Map<Boolean, String> activated() {
		Map<Boolean, String> map = new HashMap<>();
		map.put(true, "Activation");
		map.put(false, " No Activation");
		return map;
	}
	
//	<div class="mb-3">
//	<label for="name" class="form-label">ID</label>
//	<form:input path="id" id="name" class="form-control" />
//	<form:errors path="id" cssClass="text-danger" />
//</div>

}
