package com.moviehub.moviehub_api.dto.user;

import com.moviehub.moviehub_api.domain.enums.Role;

public record UserResponseDTO(
        Long id,
        String nome,
        String email,
        Role role
) {}
