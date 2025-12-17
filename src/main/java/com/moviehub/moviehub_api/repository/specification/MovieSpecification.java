package com.moviehub.moviehub_api.repository.specification;

import com.moviehub.moviehub_api.domain.entity.Movie;
import org.springframework.data.jpa.domain.Specification;

public class MovieSpecification {

    public static Specification<Movie> nomeLike(String nome) {
        return (root, query, cb) ->
                nome == null ? null :
                cb.like(cb.lower(root.get("nome")), "%" + nome.toLowerCase() + "%");
    }

    public static Specification<Movie> diretorLike(String diretor) {
        return (root, query, cb) ->
                diretor == null ? null :
                cb.like(cb.lower(root.get("diretor")), "%" + diretor.toLowerCase() + "%");
    }

    public static Specification<Movie> generoLike(String genero) {
        return (root, query, cb) ->
                genero == null ? null :
                cb.like(cb.lower(root.get("genero")), "%" + genero.toLowerCase() + "%");
    }

    public static Specification<Movie> atoresLike(String atores) {
        return (root, query, cb) ->
                atores == null ? null :
                cb.like(cb.lower(root.get("atores")), "%" + atores.toLowerCase() + "%");
    }
}
