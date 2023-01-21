package com.example.crudlover.services;

import com.example.crudlover.dtos.AccountDTO;
import com.example.crudlover.models.AccountModel;
import com.example.crudlover.repositories.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public String deleteAccountById(String id) {
        String message = "Ok";
        Optional<AccountModel> account = repository.findById(id);
        if(account.isPresent()) {
            repository.deleteById(id);
            return message;
        }
        message = "This account id doesn't exists.";
        return message;
    }

    public void updateAccountById(String id, AccountDTO data) {
        repository.findById(id).map((account) -> {
            account.setEmail(data.email());
            account.setName(data.name());
            account.setPassword(data.password());
            return repository.save(account);
        });

    }

}
