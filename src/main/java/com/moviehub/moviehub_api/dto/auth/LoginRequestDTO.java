package com.moviehub.moviehub_api.dto.auth;

public record LoginRequestDTO(
        String email,
        String senha
) {}
