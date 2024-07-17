package com.example.ASM.repository;

import com.example.ASM.entity.orderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface orderDetailRepository extends JpaRepository<orderDetail, Integer> {
}
