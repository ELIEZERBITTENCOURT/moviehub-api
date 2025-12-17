package com.moviehub.moviehub_api.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
    name = "votes",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_id", "movie_id"})
    }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer nota; // 0 a 4

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;
}