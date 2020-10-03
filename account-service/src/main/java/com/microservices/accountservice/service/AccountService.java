package com.microservices.accountservice.service;


import com.microservices.accountservice.entity.Account;

import java.util.List;

/**
 * @author erayy
 */
public interface AccountService {

    Account get(String id);

    Account save(Account account);

    Account update(String id, Account account);

    void delete(String id);

    List<Account> findAll();
}
