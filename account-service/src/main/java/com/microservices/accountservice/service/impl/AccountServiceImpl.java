package com.microservices.accountservice.service.impl;

import com.microservice.client.contract.AccountDto;
import com.microservices.accountservice.repo.AccountRepo;
import com.microservices.accountservice.entity.Account;
import com.microservices.accountservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author erayy
 */
@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepo accountRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<AccountDto> findAll(Pageable pageable) {

        Slice<Account> all = accountRepository.findAll(pageable);
        return all
                .stream()
                .map(it -> modelMapper.map(it, AccountDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public AccountDto get(String id) {
        Account account = accountRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        return modelMapper.map(account, AccountDto.class);
    }

    @Override
    public AccountDto save(AccountDto accountDto) {
        Account account = modelMapper.map(accountDto, Account.class);
        accountRepository.save(account);
        accountDto.setId(account.getId());
        return accountDto;
    }

    @Override
    @Transactional
    public AccountDto update(String id, AccountDto accountDto) {
        Assert.isNull(id, "Id cannot be null");
        Optional<Account> accountOptional = accountRepository.findById(id);
        Account account = accountOptional.map(it -> {
            it.setBirthDate(accountDto.getBirthDate());
            it.setName(accountDto.getName());
            it.setSurname(accountDto.getSurname());
            return it;
        }).orElseThrow(IllegalArgumentException::new);

        return modelMapper.map(accountRepository.save(account), AccountDto.class);
    }

    @Override
    @Transactional
    public void delete(String id) {
        Account account = accountRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        accountRepository.delete(account);
    }
}
