package com.moviehub.moviehub_api.dto.movie;

public record MovieResponseDTO(
        Long id,
        String nome,
        String diretor,
        String genero,
        String atores,
        Integer ano,
        String descricao,
        Double mediaVotos,
        Long totalVotos
) {}