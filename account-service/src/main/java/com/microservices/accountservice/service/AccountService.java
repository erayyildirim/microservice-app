package com.microservices.accountservice.service;


import com.microservice.client.contract.AccountDto;
import org.springframework.data.domain.Pageable;


import java.util.List;

/**
 * @author erayy
 */
public interface AccountService {

    AccountDto get(String id);

    AccountDto save(AccountDto account);

    AccountDto update(String id, AccountDto account);

    void delete(String id);

    List<AccountDto> findAll(Pageable pageable);
}
