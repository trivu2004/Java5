package com.j5.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.j5.dao.ProductDAO;
import com.j5.entity.Product;
import com.j5.entity.Report;
import com.j5.service.SessionService;

@Controller
public class ProductController {
	@Autowired
	ProductDAO dao;
	
	@Autowired
	SessionService session;
	
@RequestMapping("/report/inventory-by-category")
public String inventory(Model model) {
	List<Report> items = dao.getInventoryByCategory();
	model.addAttribute("items", items);
	return "report/inventory-by-category";
}
	
@RequestMapping("/product/search-and-page")
public String searchAndPage(Model model, 
		@RequestParam("keywords") Optional<String> kw,
		@RequestParam("p") Optional<Integer> p) {
	String keywords = kw.orElse(session.get("keywords", ""));
	session.set("keywords", keywords);
	Pageable pageable = PageRequest.of(p.orElse(0), 5);
	//Page<Product> page = dao.findByKeywords("%"+keywords+"%", pageable);
	Page<Product> page = dao.findAllByNameLike("%"+keywords+"%", pageable);
	model.addAttribute("page", page);
	return "product/search-and-page";
}
	
	@RequestMapping("/product/search")
	public String search(Model model, 
			@RequestParam("min") Optional<Double> min,
			@RequestParam("max") Optional<Double> max) {
		double minPrice = min.orElse(Double.MIN_VALUE);
		double maxPrice = max.orElse(Double.MAX_VALUE);
		//List<Product> items = dao.findByPrice(minPrice, maxPrice);
		List<Product> items = dao.findByPriceBetween(minPrice, maxPrice);
		model.addAttribute("items", items);
		return "product/search";
	}
	
	@RequestMapping("/product/sort")
	public String sort(Model model, 
			@RequestParam("field") Optional<String> field) {
		Sort sort = Sort.by(Direction.DESC, field.orElse("price"));
		model.addAttribute("field", field.orElse("price").toUpperCase());
		List<Product> items = dao.findAll(sort);
		model.addAttribute("items", items);
		return "product/sort";
	}
	
	@RequestMapping("/product/page")
	public String paginate(Model model,
			@RequestParam("p") Optional<Integer> p) {
		Pageable pageable = PageRequest.of(p.orElse(0), 5);
		Page<Product> page = dao.findAll(pageable);
		model.addAttribute("page", page);
		return "product/page";
	}
}