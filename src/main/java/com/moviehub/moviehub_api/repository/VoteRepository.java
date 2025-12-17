package com.moviehub.moviehub_api.repository;

import com.moviehub.moviehub_api.domain.entity.Movie;
import com.moviehub.moviehub_api.domain.entity.User;
import com.moviehub.moviehub_api.domain.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VoteRepository extends JpaRepository<Vote, Long> {

    Optional<Vote> findByUserAndMovie(User user, Movie movie);

    long countByMovie(Movie movie);
}