package com.example.demo;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.DAO.AccountDAO;
import com.example.demo.model.Account;
import com.example.demo.utlis.SessionService_Login;
import com.example.demo.utlis.ShoppingCartService;

@Controller
public class Login_Controller {
	@Autowired
	AccountDAO dao;
	@Autowired
	SessionService_Login session;
	@Autowired
	ShoppingCartService cart;

	@GetMapping("/login")
	public String login() {
		return "include/login";
	}

	@PostMapping("/login")
	public String login(Model model, @RequestParam("username") String username,
			@RequestParam("password") String password) {

		try {
			Account user = dao.getOne(username);
			if (user != null && user.getPassword().equals(password)) {
				session.set("user", user);
				model.addAttribute("name", user.getUsername());
				if (user.isAdmin()) {
					return "redirect:/admin/account";
				} else {
					return "redirect:/index";
				}
			} else {
				model.addAttribute("message", "Invalid username or password");
				return "redirect:/login";
			}
		} catch (Exception e) {
			model.addAttribute("message", "An error occurred");
			e.printStackTrace();
			return "redirect:/login";
		}
	}

	@RequestMapping("/signup")
	public String signup1(Model model) {
		model.addAttribute("item", new Account());
		return "include/signup";
	}

	@PostMapping("/signup")
	public String signup(Account item, Model md) {
		try {
			item.setActivated(true);
			item.setAdmin(false);
			item.setPhoto("");
			dao.save(item);
			return "redirect:/login";
		} catch (Exception e) {
			md.addAttribute("msg", "sai");
		}
		return "redirect:/signup";
	}

	@RequestMapping("/logout")
	public String logout() {
		session.remove("user");
		cart.clear();
		return "redirect:/index";
	}

}
