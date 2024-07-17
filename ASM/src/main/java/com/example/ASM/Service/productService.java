package com.example.ASM.Service;

import com.example.ASM.entity.product;

import java.util.List;

public interface productService {
    public product getProduct(int id);
    public List<product> getAllProduct();
    public List<product> getProductByName(String productName);
    public product addProduct(product product);
    public product updateProduct(product product);
    public void deleteProduct(product product);
}
