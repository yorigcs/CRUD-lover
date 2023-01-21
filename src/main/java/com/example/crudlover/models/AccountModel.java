package com.example.crudlover.models;

import com.example.crudlover.dtos.AccountDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class AccountModel {

    public AccountModel(AccountDTO data) {
        this.email = data.email();
        this.name = data.name();
        this.password = data.password();
    }
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(length = 50,nullable = false)
    private String name;

    @Column(length = 60, nullable = false)
    private String email;

    @Column(length = 20, nullable = false)
    private String password;

}
