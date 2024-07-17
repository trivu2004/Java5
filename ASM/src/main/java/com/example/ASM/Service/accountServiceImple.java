package com.example.ASM.Service;

import com.example.ASM.entity.account;
import com.example.ASM.repository.accountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class accountServiceImple implements accountService {
    @Autowired
    private accountRepository accountRepository;

    @Override
    public account getAccountById(int id) {
        return accountRepository.getOne(id);
    }

    @Override
    public account addAccount(account account) {
        return accountRepository.save(account);
    }

    @Override
    public void deleteAccount(int id) {
        accountRepository.deleteById(id);
    }

    @Override
    public account updateAccount(account account) {
        return accountRepository.saveAndFlush(account);
    }
}
