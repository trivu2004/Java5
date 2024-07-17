package com.example.ASM.Service;

import com.example.ASM.entity.product;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

public interface orderDetailService {
    product addProduct(int id);
    void removeProduct(int id);
    product updateProduct(int id, int qty);
    List<Integer> getAllIds();
    Collection<product> getItems();
    int getCount();
    double getAmount();
    int getQty(int id);
    double getPrice(int id);
}
