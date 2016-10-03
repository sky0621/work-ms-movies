package com.github.sky0621.work.ms.movies.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.sky0621.work.ms.movies.domain.repository.MovieRepository;
import com.github.sky0621.work.ms.movies.domain.resource.MovieResource;

@Service
public class MovieService {

	@Autowired
	MovieRepository movieRepository;

	public List<MovieResource> findAll() {
		// エンティティからリソースへの詰め替え
		return movieRepository.findAll().stream().map(movie -> {
			MovieResource resource = new MovieResource();
			resource.setId(movie.getId());
			resource.setName(movie.getName());
			resource.setDatetime(movie.getDatetime());
			resource.setPath(movie.getPath());
			return resource;
		}).collect(Collectors.toList());
	}

}
