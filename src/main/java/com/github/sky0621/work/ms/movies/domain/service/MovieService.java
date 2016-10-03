package com.github.sky0621.work.ms.movies.domain.service;

import java.util.ArrayList;
import java.util.List;
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

	// FIXME �_�~�[�����̂��߂̃������ێ����X�g
	static List<MovieResource> movieResources = new ArrayList<>();

	public List<MovieResource> findAll() {
		List<Movie> movieList = movieRepository.findAll();
		movieResources = movieList.stream().map(movie -> {
			MovieResource resource = new MovieResource();
			resource.setId(movie.getId());
			resource.setName(movie.getName());
			resource.setDatetime(movie.getDatetime());
			resource.setPath(movie.getPath());
			return resource;
		}).collect(Collectors.toList());

		// FIXME �_�~�[����
		// MovieResource res = new MovieResource();
		// res.setId("000000-000000-00000000-00000000");
		// res.setName("�T���v������");
		// res.setDatetime(LocalDate.of(2016, 10, 1));
		// res.setPath("sample.mp4");
		// movieResources.add(res);
		return movieResources;
	}

}
