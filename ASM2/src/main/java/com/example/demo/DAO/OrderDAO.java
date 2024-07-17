package com.example.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Order;



public interface OrderDAO extends JpaRepository<Order, Long> {
}
