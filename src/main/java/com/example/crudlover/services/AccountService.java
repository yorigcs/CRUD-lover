package com.example.crudlover.services;

import com.example.crudlover.dtos.AccountDTO;
import com.example.crudlover.models.AccountModel;
import com.example.crudlover.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    private final AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public void save(AccountDTO data) {
        repository.save(new AccountModel(data));
    }

    public  List<AccountModel> findAll() {
        return repository.findAll();
    }

}
