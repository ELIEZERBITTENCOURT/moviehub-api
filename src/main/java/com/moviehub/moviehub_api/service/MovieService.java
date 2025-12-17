package com.moviehub.moviehub_api.service;

import com.moviehub.moviehub_api.domain.entity.Movie;
import com.moviehub.moviehub_api.dto.movie.MovieCreateDTO;
import com.moviehub.moviehub_api.dto.movie.MovieResponseDTO;
import com.moviehub.moviehub_api.repository.MovieRepository;
import com.moviehub.moviehub_api.repository.VoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.moviehub.moviehub_api.repository.specification.MovieSpecification.*;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final VoteRepository voteRepository;

    public MovieResponseDTO create(MovieCreateDTO dto) {

        Movie movie = Movie.builder()
                .nome(dto.nome())
                .diretor(dto.diretor())
                .genero(dto.genero())
                .atores(dto.atores())
                .ano(dto.ano())
                .descricao(dto.descricao())
                .build();

        movieRepository.save(movie);

        return toResponse(movie);
    }

    public List<MovieResponseDTO> list(
            String nome,
            String diretor,
            String genero,
            String atores
    ) {
        Specification<Movie> spec = Specification
                .where(nomeLike(nome))
                .and(diretorLike(diretor))
                .and(generoLike(genero))
                .and(atoresLike(atores));

        return movieRepository.findAll(spec)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    private MovieResponseDTO toResponse(Movie movie) {

        long totalVotos = voteRepository.countByMovie(movie);
        Double media = totalVotos == 0 ? 0.0 :
                movie.getVotes()
                        .stream()
                        .mapToInt(v -> v.getNota())
                        .average()
                        .orElse(0.0);

        return new MovieResponseDTO(
                movie.getId(),
                movie.getNome(),
                movie.getDiretor(),
                movie.getGenero(),
                movie.getAtores(),
                movie.getAno(),
                movie.getDescricao(),
                media,
                totalVotos
        );
    }
}
