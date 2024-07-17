package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.DAO.CategoryDAO;
import com.example.demo.DAO.ProductDAO;
import com.example.demo.model.Category;
import com.example.demo.model.Product;

@Controller
public class sp_Controller {

	@Autowired
	ProductDAO dao;
	@Autowired
	CategoryDAO caedao;

	@RequestMapping("/sp")
	public String product(Model md) {
		List<Product> items = dao.findAll();
		md.addAttribute("items", items);
		List<Category> cate = caedao.findAll();
		md.addAttribute("cate", cate);
		return "include/sp";
	}

	@RequestMapping("/sp/{id}")
	public String category(Model md, @PathVariable("id") String id) {
		List<Product> items = dao.findByIdCategory(id);
		md.addAttribute("items", items);
		List<Category> cate = caedao.findAll();
		md.addAttribute("cate", cate);
		return "include/sp";
	}

	@RequestMapping("/sp/price")
	public String sort(Model model, @RequestParam("min") Optional<Double> min,
			@RequestParam("max") Optional<Double> max) {
		double minPrice = min.orElse(Double.MIN_VALUE);
		double maxPrice = max.orElse(Double.MAX_VALUE);
		List<Product> items = dao.findByPriceBetween(minPrice, maxPrice);
		model.addAttribute("items", items);
		List<Category> cate = caedao.findAll();
		model.addAttribute("cate", cate);
		return "include/sp";
	}

}
