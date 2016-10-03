package com.github.sky0621.work.ms.movies.app;

import static com.github.sky0621.work.ms.movies.domain.converter.MovieConverter.toMovie;
import static com.github.sky0621.work.ms.movies.domain.converter.MovieConverter.toMovieResource;
import static com.github.sky0621.work.ms.movies.domain.converter.MovieConverter.toMovieResourceList;
import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.on;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.github.sky0621.work.ms.movies.domain.error.MovieResourceNotFoundException;
import com.github.sky0621.work.ms.movies.domain.resource.MovieResource;
import com.github.sky0621.work.ms.movies.domain.service.MovieService;

// I know Resource
// I know Service
@RestController
@RequestMapping("movies")
public class MovieRestController {

	@Autowired
	MovieService movieService;

	/*
	 * 全件取得
	 */
	// TODO デフォルト取得件数を適用
	// TODO デフォルトソート順を適用
	@RequestMapping(method = RequestMethod.GET)
	public List<MovieResource> getMovies() {
		return toMovieResourceList(movieService.findAll());
	}

	/*
	 * １リソース取得
	 */
	@RequestMapping(path = "{id}", method = RequestMethod.GET)
	public MovieResource getMovie(@PathVariable String id) {
		MovieResource resource = toMovieResource(movieService.find(id));
		if (resource == null) {
			throw new MovieResourceNotFoundException(id);
		}
		return resource;
	}

	/*
	 * １件作成
	 */
	// TODO バリデーションを実装
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<MovieResource> createMovie(@Validated @RequestBody MovieResource resource,
			UriComponentsBuilder uriBuilder) {
		MovieResource createdMovie = toMovieResource(movieService.create(toMovie(resource)));

		URI resourceUri = MvcUriComponentsBuilder.relativeTo(uriBuilder)
				.withMethodCall(on(MovieRestController.class).getMovie(createdMovie.getId())).build().encode().toUri();

		// 201 Createdを設定（Locationヘッダーに新規作成したリソースのURIを設定）
		return ResponseEntity.created(resourceUri).body(createdMovie);
	}

}
