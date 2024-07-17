package com.example.ASM.Dao;

import com.example.ASM.entity.orderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailDAO extends JpaRepository<orderDetail, Integer> {

}