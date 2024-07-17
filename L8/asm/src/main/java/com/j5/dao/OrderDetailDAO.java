package com.j5.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.j5.entity.OrderDetail;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long>{
}