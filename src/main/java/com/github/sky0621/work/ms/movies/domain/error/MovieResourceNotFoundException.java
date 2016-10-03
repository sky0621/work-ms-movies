package com.github.sky0621.work.ms.movies.domain.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MovieResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MovieResourceNotFoundException(String id) {
		super("Movie is not founc (id = " + id + ")");
	}

}
