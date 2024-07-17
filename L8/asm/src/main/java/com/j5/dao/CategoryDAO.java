package com.j5.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.j5.entity.Category;

public interface CategoryDAO extends JpaRepository<Category, String>{
}
