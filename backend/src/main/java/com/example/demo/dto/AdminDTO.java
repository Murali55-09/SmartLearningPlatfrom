package com.example.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AdminDTO {
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Please enter a valid email")
    private String email;

    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    // Getters & Setters
}
