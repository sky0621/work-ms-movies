package com.github.sky0621.work.ms.movies.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.github.sky0621.work.ms.movies.domain.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, String> {

	@Query("SELECT m FROM Movie m WHERE m.id = :id")
	public Movie findById(@Param("id") String id);

}
