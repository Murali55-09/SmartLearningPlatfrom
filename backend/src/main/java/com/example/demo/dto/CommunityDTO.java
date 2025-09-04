package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;

public class CommunityDTO {
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    private String description;

    // Getters and Setters
}
