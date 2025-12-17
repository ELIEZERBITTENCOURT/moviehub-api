package com.moviehub.moviehub_api.dto.user;

import com.moviehub.moviehub_api.domain.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserCreateDTO(

        @NotBlank String nome,

        @Email @NotBlank String email,

        @NotBlank String senha,

        @NotNull Role role
) {}
