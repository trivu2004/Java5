package com.example.demo.utlis;

import java.util.Collection;

import com.example.demo.model.Product;
import java.util.List;

public interface ShoppingCartService {
	Product add(Integer id);

	void remove(Integer id);

	Product update(Integer id, Integer qty);

	void clear();

	List<Integer> getAllIds();

	Collection<Product> getItems();

	int getCount();

	double getAmount();

	int getQty(Integer id);

	double getPrice(Integer id);

}
