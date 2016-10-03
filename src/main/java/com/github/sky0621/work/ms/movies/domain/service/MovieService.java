package com.github.sky0621.work.ms.movies.domain.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.sky0621.work.ms.movies.domain.entity.Movie;
import com.github.sky0621.work.ms.movies.domain.repository.MovieRepository;

// I know Entity
// I know Repository
@Service
public class MovieService {

	@Autowired
	MovieRepository movieRepository;

	/*
	 * 全件取得
	 */
	public List<Movie> findAll() {
		return movieRepository.findAll();
	}

	/*
	 * １件取得（サロゲートキー）
	 */
	public Movie find(String id) {
		return movieRepository.findById(id);
	}

	/*
	 * １件作成
	 */
	public Movie create(Movie movie) {
		movie.setId(UUID.randomUUID().toString());
		return movieRepository.save(movie);
	}

}
