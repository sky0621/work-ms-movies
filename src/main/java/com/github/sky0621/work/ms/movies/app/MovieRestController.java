package com.github.sky0621.work.ms.movies.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.sky0621.work.ms.movies.domain.resource.MovieResource;
import com.github.sky0621.work.ms.movies.domain.service.MovieService;

@RestController
@RequestMapping("movies")
public class MovieRestController {

	@Autowired
	MovieService movieService;

	/*
	 * 全件取得（※後々、デフォルト取得件数とソート順を定義）
	 */
	@RequestMapping(method = RequestMethod.GET)
	public List<MovieResource> getMovies() {
		return movieService.findAll();
	}

}
