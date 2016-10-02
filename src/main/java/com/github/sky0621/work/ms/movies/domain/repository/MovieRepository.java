package com.github.sky0621.work.ms.movies.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.sky0621.work.ms.movies.domain.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, String> {

}
