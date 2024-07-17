package com.example.lab4.cart;

import com.example.lab4.model.Item;

import java.util.Collection;

public interface ShoppingCartService {

    Item add(Integer id);

    Item update(Integer id, int qty);

    void remove(Integer id);

    void clear();

    Collection<Item> getItems();

    int getCount();

    double getAmount();

}