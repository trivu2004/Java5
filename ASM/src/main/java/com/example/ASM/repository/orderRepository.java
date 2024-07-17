package com.example.ASM.repository;

import com.example.ASM.entity.order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface orderRepository extends JpaRepository<order, Integer> {
}
