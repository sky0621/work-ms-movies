package com.github.sky0621.work.ms.movies.domain.converter;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.stream.Collectors;

import com.github.sky0621.work.ms.movies.domain.entity.Movie;
import com.github.sky0621.work.ms.movies.domain.resource.MovieResource;

public final class MovieConverter {

	public static Movie toMovie(MovieResource resource) {
		Movie movie = new Movie();
		movie.setId(resource.getId());
		movie.setName(resource.getName());
		movie.setDt(Date.valueOf(resource.getDt()));
		movie.setTm(Time.valueOf(resource.getTm()));
		movie.setPath(resource.getPath());
		return movie;
	}

	public static MovieResource toMovieResource(Movie movie) {
		MovieResource resource = new MovieResource();
		resource.setId(movie.getId());
		resource.setName(movie.getName());
		resource.setDt(movie.getDt().toLocalDate());
		resource.setTm(movie.getTm().toLocalTime());
		resource.setPath(movie.getPath());
		return resource;
	}

	public static List<MovieResource> toMovieResourceList(List<Movie> movieList) {
		return movieList.stream().map(movie -> toMovieResource(movie)).collect(Collectors.toList());
	}

}
