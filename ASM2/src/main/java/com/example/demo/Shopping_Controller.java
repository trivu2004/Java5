package com.example.demo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.DAO.AccountDAO;
import com.example.demo.DAO.OrderDAO;
import com.example.demo.DAO.OrderDetailDAO;
import com.example.demo.model.Account;
import com.example.demo.model.Order;
import com.example.demo.model.OrderDetail;
import com.example.demo.model.Product;
import com.example.demo.utlis.SessionService_Login;
import com.example.demo.utlis.ShoppingCartService;

import jakarta.servlet.http.HttpSession;

@Controller
public class Shopping_Controller {
	@Autowired
	ShoppingCartService cart;
	@Autowired
	SessionService_Login session1;
	@Autowired
	AccountDAO acdao;
	@Autowired
	OrderDAO ordao;
	@Autowired
	OrderDetailDAO ordldao;

	@RequestMapping("/cart/view")
	public String view2(Model md) {
		md.addAttribute("cart", cart);
		md.addAttribute("total", cart.getAmount());
//		md.addAttribute("cart", cart.getCount());
		return "include/cart";
	}

	@RequestMapping("/cart/add/{id}")
	public String add(@PathVariable("id") Integer id, HttpSession session) {
		if (!session1.isUserLoggedIn(session)) {

			return "redirect:/login";
		}

		cart.add(id);
		return "redirect:/cart/view";
	}

	@RequestMapping("/cart/remove/{id}")
	public String remove(@PathVariable("id") Integer id) {
		cart.remove(id);
		return "redirect:/cart/view";
	}

	@RequestMapping("/cart/update/{id}")
	public String update(@PathVariable("id") Integer id, @RequestParam("qty") Integer qty, @Validated Product item,
			BindingResult errors) {
		if (errors.hasErrors()) {
			item.setQty(1);
		} else {
			cart.update(id, qty);
		}
		return "redirect:/cart/view";
	}

	@RequestMapping("/cart/clear")
	public String clear() {
		cart.clear();
		return "redirect:/cart/view";
	}

	@RequestMapping("/paying")
	public String pay(Integer id) {
		Account user = (Account) session1.get("user");
		Order order = new Order();
		Product pro = new Product();
		order.setUser(user.getUsername());
		order.setCreateDate(new Date());
		order.setAddress(null);
		ordao.save(order);

		List<Integer> ids = cart.getAllIds();

		for (Integer idInteger : ids) {
			OrderDetail od = new OrderDetail();
			od.setOdid(order.getId());
			od.setPrice(cart.getPrice(idInteger) * cart.getQty(idInteger));
			od.setProid(idInteger);
			od.setQuantity(cart.getQty(idInteger));
			ordldao.save(od);
		}
		cart.clear();
		return "redirect:/cart/view";
	}
}
