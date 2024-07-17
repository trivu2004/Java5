package com.example.demo.utlis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.ProductDAO;
import com.example.demo.model.Product;

import java.util.List;

@Service
public class ShoppingCartIMP implements ShoppingCartService {
	Map<Integer, Product> map = new HashMap<>();

	@Autowired
	private ProductDAO dao;

	@Override
	public Product add(Integer id) {
		Product item = map.get(id);
		if (item == null) {
			item = dao.getProductById(id);
			item.setQty(1);
			map.put(id, item);
		} else {
			item.setQty(item.getQty() + 1);
		}
		return item;
	}

	@Override
	public void remove(Integer id) {
		map.remove(id);
	}

	@Override
	public Product update(Integer id, Integer qty) {
		Product item = map.get(id);
		item.setQty(qty);
		return item;
	}

	@Override
	public void clear() {
		map.clear();
	}

	@Override
	public Collection<Product> getItems() {
		return map.values();
	}

	@Override
	public int getCount() {
		return map.values().stream().mapToInt(item -> item.getQty()).sum();
	}

	@Override
	public double getAmount() {
		return map.values().stream().mapToDouble(item -> item.getPrice() * item.getQty()).sum();
	}

	@Override
	public int getQty(Integer id) {
		Product product = map.get(id);
		if (product != null) {
			return product.getQty();
		} else {
			return 0;
		}
	}

	@Override
	public double getPrice(Integer id) {
		Product product = map.get(id);
		if (product != null) {
			return product.getPrice();
		} else {
			return 0;
		}
	}
//	@Override
//	public Integer  getId() {
//		Product item = new Product();
//		return item.getId();
//	}

	@Override
	public List<Integer> getAllIds() {
		List<Integer> ids = new ArrayList<>();
		for (Product product : map.values()) {
			ids.add(product.getId());
		}
		return ids;
	}

}
