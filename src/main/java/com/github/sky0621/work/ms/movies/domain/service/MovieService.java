package com.github.sky0621.work.ms.movies.domain.service;

import static com.github.sky0621.work.ms.movies.domain.converter.MovieConverter.toMovieResource;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.sky0621.work.ms.movies.domain.entity.Movie;
import com.github.sky0621.work.ms.movies.domain.repository.MovieRepository;
import com.github.sky0621.work.ms.movies.domain.resource.MovieResource;

@Service
public class MovieService {

	@Autowired
	MovieRepository movieRepository;

	/*
	 * 全件取得
	 */
	public List<MovieResource> findAll() {
		// エンティティからリソースへの詰め替え
		return movieRepository.findAll().stream().map(movie -> toMovieResource(movie)).collect(Collectors.toList());
	}

	/*
	 * １件取得（サロゲートキー）
	 */
	public MovieResource find(String id) {
		return toMovieResource(movieRepository.findById(id));
	}

	/*
	 * １件作成
	 */
	public MovieResource create(Movie movie) {
		movie.setId(UUID.randomUUID().toString());
		return toMovieResource(movieRepository.save(movie));
	}

}
