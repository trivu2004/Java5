package com.j5.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.j5.entity.Order;

public interface OrderDAO extends JpaRepository<Order, Long>{
}
