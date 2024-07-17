package com.example.ASM.Service;


import com.example.ASM.entity.account;

public interface accountService {
    account getAccountById(int id);
    public account addAccount(account account);
    public void deleteAccount(int id);
    public account updateAccount(account account);
}
