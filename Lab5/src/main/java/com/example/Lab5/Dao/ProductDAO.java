package com.example.Lab5.Dao;

import com.example.Lab5.entity.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDAO extends JpaRepository<product, Integer> {

}

