package com.moviehub.moviehub_api.service;

import com.moviehub.moviehub_api.domain.entity.Movie;
import com.moviehub.moviehub_api.domain.entity.User;
import com.moviehub.moviehub_api.domain.entity.Vote;
import com.moviehub.moviehub_api.dto.vote.VoteRequestDTO;
import com.moviehub.moviehub_api.repository.MovieRepository;
import com.moviehub.moviehub_api.repository.VoteRepository;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

import org.springframework.stereotype.Service;
import com.moviehub.moviehub_api.exception.BusinessException;
import com.moviehub.moviehub_api.exception.NotFoundException;

@Service
@RequiredArgsConstructor
public class VoteService {

    private final VoteRepository voteRepository;
    private final MovieRepository movieRepository;

    public void vote(User user, VoteRequestDTO dto) {

        Long movieId = Objects.requireNonNull(dto.movieId(), "movieId não pode ser null");

        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new NotFoundException("Filme não encontrado"));

        if (voteRepository.findByUserAndMovie(user, movie).isPresent()) {
            throw new BusinessException("Usuário já votou neste filme");
        }

        Vote vote = Objects.requireNonNull(
        Vote.builder()
                .user(user)
                .movie(movie)
                .nota(dto.nota())
                .build(),
            "Vote não pode ser null"
        );

        voteRepository.save(vote);
    }
}
