package com.example.Lab5.Dao;


import com.example.Lab5.entity.account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDAO extends JpaRepository<account, Integer> {

}