package com.example.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Category;


public interface CategoryDAO extends JpaRepository<Category, String> {
}


