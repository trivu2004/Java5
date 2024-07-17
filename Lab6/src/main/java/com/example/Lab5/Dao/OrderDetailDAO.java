package com.example.Lab5.Dao;

import com.example.Lab5.entity.orderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailDAO extends JpaRepository<orderDetail, Integer> {

}