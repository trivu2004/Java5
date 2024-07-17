package com.example.ASM.Dao;


import com.example.ASM.entity.account;
import com.example.ASM.entity.product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


public interface AccountDAO extends JpaRepository<account, Integer> {
    account findFirstByUsername(String username);
    account findByEmail(String email);
    @Query("SELECT p FROM account p WHERE p.username LIKE :keywords")
    Page<account> findByKeywords(@Param("keywords") String keywords, Pageable pageable);
}