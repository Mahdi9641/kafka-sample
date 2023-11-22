package com.example.kafka.serviceRepo;

import com.example.kafka.domain.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public String createAccount(Account account){
        accountRepository.save(account);
        return "account was created";
    }


    public  List<Account> findAllAccount(){
        List<Account> accounts = accountRepository.findAll();
        return accounts;
    }
}
