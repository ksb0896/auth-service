package com.ksb.micro.auth_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterRequest(
        @NotBlank(message = "Username cannot be blank")
        String username,

        @NotBlank(message = "Password cannot be empty")
        @Size(min = 4, max = 6, message = "Password must be between 4 to 6 characters long")
        String password
) {}
