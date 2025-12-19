package com.moviehub.moviehub_api.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "movies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NonNull
    private String nome;

    @Column(nullable = false)
    @NonNull
    private String diretor;

    @Column(nullable = false)
    @NonNull
    private String genero;

    @Column(nullable = false)
    @NonNull
    private String atores;

    @NonNull
    private Integer ano;

    @Column(length = 1000)
    @NonNull
    private String descricao;

    @OneToMany(mappedBy = "movie")
    private List<Vote> votes;
}
