package com.moviehub.moviehub_api.domain.entity;

import com.moviehub.moviehub_api.domain.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NonNull
    private String nome;

    @Column(nullable = false, unique = true)
    @NonNull
    private String email;

    @Column(nullable = false)
    @NonNull
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NonNull
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<Vote> votes;
}
