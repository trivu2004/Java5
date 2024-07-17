package com.example.Lab5.Dao;

import com.example.Lab5.entity.order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDAO extends JpaRepository<order, Integer> {

}

