package com.moviehub.moviehub_api.service;

import com.moviehub.moviehub_api.domain.entity.Movie;
import com.moviehub.moviehub_api.domain.entity.User;
import com.moviehub.moviehub_api.domain.entity.Vote;
import com.moviehub.moviehub_api.dto.vote.VoteRequestDTO;
import com.moviehub.moviehub_api.repository.MovieRepository;
import com.moviehub.moviehub_api.repository.VoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.moviehub.moviehub_api.exception.BusinessException;
import com.moviehub.moviehub_api.exception.NotFoundException;

@Service
@RequiredArgsConstructor
public class VoteService {

    private final VoteRepository voteRepository;
    private final MovieRepository movieRepository;

    public void vote(User user, VoteRequestDTO dto) {

        Movie movie = movieRepository.findById(dto.movieId())
                .orElseThrow(() -> new NotFoundException("Filme não encontrado"));

        voteRepository.findByUserAndMovie(user, movie)
                .ifPresent(v -> {
                    throw new BusinessException("Usuário já votou neste filme");
                });

        Vote vote = Vote.builder()
                .user(user)
                .movie(movie)
                .nota(dto.nota())
                .build();

        voteRepository.save(vote);
    }
}
