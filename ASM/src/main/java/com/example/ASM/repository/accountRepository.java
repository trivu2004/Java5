package com.example.ASM.repository;

import com.example.ASM.entity.account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface accountRepository extends JpaRepository<account, Integer> {
}
