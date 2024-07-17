package com.example.BaoVeASM.reponsitory;

import com.example.BaoVeASM.Model.account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface accountRepository extends JpaRepository<account, Integer> {
}
