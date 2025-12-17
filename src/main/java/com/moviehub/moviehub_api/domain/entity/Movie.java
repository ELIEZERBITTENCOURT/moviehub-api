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
    private String nome;

    @Column(nullable = false)
    private String diretor;

    @Column(nullable = false)
    private String genero;

    @Column(nullable = false)
    private String atores;

    private Integer ano;

    @Column(length = 1000)
    private String descricao;

    @OneToMany(mappedBy = "movie")
    private List<Vote> votes;
}
