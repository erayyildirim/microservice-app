package com.microservices.accountservice.service.impl;

import com.microservices.accountservice.repo.AccountRepo;
import com.microservices.accountservice.entity.Account;
import com.microservices.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author erayy
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private  AccountRepo accountRepository;


    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account get(String id) {
         return accountRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account update(String id, Account account) {
        Assert.isNull(id, "Id cannot be null");
        return accountRepository.save(account);
    }

    @Override
    public void delete(String id) {

    }
}
