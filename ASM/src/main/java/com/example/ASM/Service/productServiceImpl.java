package com.example.ASM.Service;

import com.example.ASM.entity.product;
import com.example.ASM.repository.productRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class productServiceImpl implements productService {
    private productRepository repository;

    @Autowired
    public productServiceImpl(productRepository repository) {
        this.repository = repository;
    }

    @Override
    public product getProduct(int id) {
        return repository.getById(id);
    }

    @Override
    public List<product> getAllProduct() {
        return List.of();
    }

    @Override
    public List<product> getProductByName(String productName) {
        return List.of();
    }

    @Override
    public product addProduct(product product) {
        return null;
    }

    @Override
    public product updateProduct(product product) {
        return null;
    }

    @Override
    public void deleteProduct(product product) {

    }
}
