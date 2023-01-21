package com.example.crudlover.controllers;

import com.example.crudlover.dtos.AccountDTO;
import com.example.crudlover.models.AccountModel;
import com.example.crudlover.repositories.AccountRepository;
import com.example.crudlover.services.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class Account {
    private final AccountService service;

    public Account(AccountService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public void create(@RequestBody AccountDTO req) {
         service.save(req);
    }

    @GetMapping
    public List<AccountModel> getAllAccounts() {
        return service.findAll();
    }

}
