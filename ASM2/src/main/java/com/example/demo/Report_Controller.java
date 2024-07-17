// Report_Controller.java
package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.DAO.ProductDAO;
import com.example.demo.model.Report;

@Controller
public class Report_Controller {
	@Autowired
	ProductDAO dao;

	@RequestMapping("/report/inventory-by-category")
	public String inventory(Model model) {
		List<Report> items = dao.getInventoryByCategory();
		model.addAttribute("items", items);
		return "admin/report"; 
	}
}
