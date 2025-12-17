package com.moviehub.moviehub_api.dto.movie;

import jakarta.validation.constraints.NotBlank;

public record MovieCreateDTO(

        @NotBlank String nome,
        @NotBlank String diretor,
        @NotBlank String genero,
        @NotBlank String atores,
        Integer ano,
        String descricao
) {}
