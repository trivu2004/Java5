package com.example.BaoVeASM.Dao;

import com.example.BaoVeASM.Model.account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AccountDao extends JpaRepository<account, Integer> {
    account findFirstByUsername(String username);
    account findByEmail(String email);
    @Query("SELECT p FROM account p WHERE p.username LIKE :keywords")
    Page<account> findByKeywords(@Param("keywords") String keywords, Pageable pageable);
}
