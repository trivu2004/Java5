package com.example.demo;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.DAO.AccountDAO;
import com.example.demo.DAO.ProductDAO;
import com.example.demo.model.Account;
import com.example.demo.model.Product;
import com.example.demo.utlis.SessionService;
import com.example.demo.utlis.SessionService_Login;

@Controller
public class Item_Controller {
	@Autowired
	ProductDAO dao;
	@Autowired
	SessionService session;
	@Autowired
	AccountDAO acdao;
	@Autowired
	SessionService_Login session1;

	@RequestMapping("/index")
	public String paginate(Model md, @RequestParam("keywords") Optional<String> kw,
			@RequestParam("p") Optional<Integer> p) {
		String kwords = kw.orElse(session.get("keywords", ""));
		session.set("keywords", kwords);
		Pageable pageable = PageRequest.of(p.orElse(0), 4);
		Page<Product> page = dao.findByKeywords("%" + kwords + "%", pageable);
//		Page<Product> page = dao.findAllByNameLike("%" + kwords + "%", pageable);
//		page = dao.findAll(pageable);
		if (kwords != null && !kwords.isEmpty()) {
			page = dao.findByKeywords("%" + kwords + "%", pageable);
		} else {
			page = dao.findAll(pageable);
		}
		md.addAttribute("page", page);
		return "index";
	}

}
