package com.moviehub.moviehub_api.controller;

import com.moviehub.moviehub_api.dto.movie.MovieCreateDTO;
import com.moviehub.moviehub_api.dto.movie.MovieResponseDTO;
import com.moviehub.moviehub_api.service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    // ADMIN
    @PostMapping("/admin")
    public MovieResponseDTO create(@RequestBody @Valid MovieCreateDTO dto) {
        return movieService.create(dto);
    }

    // USUARIO / ADMIN
    @GetMapping
    public List<MovieResponseDTO> list(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String diretor,
            @RequestParam(required = false) String genero,
            @RequestParam(required = false) String atores
    ) {
        return movieService.list(nome, diretor, genero, atores);
    }
}
