package com.example.Lab5.Dao;

import com.example.Lab5.entity.category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDAO extends JpaRepository<category, Integer> {

}
