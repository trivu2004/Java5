package com.j5.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.j5.entity.Account;

public interface AccountDAO extends JpaRepository<Account, String>{
}
