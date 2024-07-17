package com.example.ASM.repository;

import com.example.ASM.entity.category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface categoryRepository extends JpaRepository<category, Integer> {
}
