package com.j5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.j5.service.ParamService;
import com.j5.service.ShoppingCartService;

@Controller
public class ShoppingCartController {
	@Autowired
	ShoppingCartService cart;
	@Autowired
	ParamService param;
	
	@RequestMapping("/cart/view")
	public String view(Model model) {
		model.addAttribute("cart", cart);
		return "cart/index";
	}

@RequestMapping("/cart/add/{id}")
public String add(@PathVariable("id") Integer id) {
	cart.add(id);
	return "redirect:/cart/view";
}

@RequestMapping("/cart/remove/{id}")
public String remove(@PathVariable("id") Integer id) {
	cart.remove(id);
	return "redirect:/cart/view";
}
@RequestMapping("/cart/update")
public String update() {
	Integer id = param.getInt("id", 0);
	int qty = param.getInt("qty", 0);
	cart.update(id, qty);
	return "redirect:/cart/view";
}

@RequestMapping("/cart/clear")
public String clear() {
	cart.clear();
	return "redirect:/cart/view";
}
}

