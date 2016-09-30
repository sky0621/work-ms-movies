package com.github.sky0621.work.ms.movies.domain.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.github.sky0621.work.ms.movies.domain.resource.MovieResource;

@Service
public class MovieService {

	// FIXME ダミー実装のためのメモリ保持リスト
	static List<MovieResource> movieResources = new ArrayList<>();

	public List<MovieResource> findAll() {
		// FIXME ダミー実装
		MovieResource res = new MovieResource();
		res.setId("000000-000000-00000000-00000000");
		res.setName("サンプル動画");
		res.setDatetime(LocalDate.of(2016, 10, 1));
		res.setPath("sample.mp4");
		movieResources.add(res);
		return movieResources;
	}

}
