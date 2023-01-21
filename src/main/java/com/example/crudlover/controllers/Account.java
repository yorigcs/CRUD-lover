package com.example.crudlover.controllers;

import com.example.crudlover.dtos.AccountDTO;
import com.example.crudlover.models.AccountModel;
import com.example.crudlover.repositories.AccountRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
public class Account {
    private final AccountRepository repository;

    public Account(AccountRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public void create(@RequestBody AccountDTO req) {
         repository.save(new AccountModel(req));
    }

}
