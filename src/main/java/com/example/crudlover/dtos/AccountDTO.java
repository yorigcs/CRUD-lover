package com.example.crudlover.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AccountDTO(
        @NotBlank
        String name,
        @Email
        String email,
        @NotBlank
        String password
) {
}
