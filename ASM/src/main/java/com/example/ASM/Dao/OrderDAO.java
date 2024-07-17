package com.example.ASM.Dao;

import com.example.ASM.entity.order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDAO extends JpaRepository<order, Integer> {

}

