package com.moviehub.moviehub_api.dto.vote;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record VoteRequestDTO(

        @NotNull Long movieId,

        @Min(0) @Max(4)
        Integer nota
) {}
