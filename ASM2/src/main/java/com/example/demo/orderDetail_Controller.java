package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.DAO.OrderDAO;
import com.example.demo.DAO.OrderDetailDAO;
import com.example.demo.model.Order;
import com.example.demo.model.OrderDetail;

@Controller
public class orderDetail_Controller {
	@Autowired
	OrderDetailDAO dao;

	@RequestMapping("/admin/orderdl")
	public String index(Model model) {
		List<OrderDetail> items = dao.findAll();
		model.addAttribute("items", items);
		return "admin/orderDL";
	}
}
