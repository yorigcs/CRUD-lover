package com.example.crudlover.controllers;

import com.example.crudlover.dtos.AccountDTO;
import com.example.crudlover.models.AccountModel;
import com.example.crudlover.repositories.AccountRepository;
import com.example.crudlover.services.AccountService;
import jakarta.validation.Valid;
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
    public void create(@RequestBody @Valid AccountDTO req) {
         service.save(req);
    }

    @GetMapping
    public List<AccountModel> getAllAccounts() {
        return service.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public  String deleteAccount(@PathVariable String id) {
       return service.deleteAccountById(id);
    }

    @PutMapping("update/{id}")
    public void updateAccount(@PathVariable String id, @Valid @RequestBody AccountDTO req) {
         service.updateAccountById(id,req);
    }

}
