package com.example.ASM.Service;

import com.example.ASM.Dao.ProductDAO;
import com.example.ASM.entity.product;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class orderDetailServiceImpl implements orderDetailService {

    Map<Integer,product> map = new HashMap<>();
    @Autowired
    private ProductDAO productDAO;
    @Override
    public product addProduct(int id) {
        return null;
    }

    @Override
    public void removeProduct(int id) {

    }

    @Override
    public product updateProduct(int id, int qty) {
        return null;
    }

    @Override
    public List<Integer> getAllIds() {
        return List.of();
    }

    @Override
    public Collection<product> getItems() {
        return List.of();
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public double getAmount() {
        return 0;
    }

    @Override
    public int getQty(int id) {
        return 0;
    }

    @Override
    public double getPrice(int id) {
        return 0;
    }
}
