package com.github.sky0621.work.ms.movies.domain.resource;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MovieResource implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private String name;

	@JsonFormat(pattern = "yyyy/MM/dd")
	private LocalDate dt;

	@JsonFormat(pattern = "HH:mm:ss")
	private LocalTime tm;

	private String path;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDt() {
		return dt;
	}

	public void setDt(LocalDate dt) {
		this.dt = dt;
	}

	public LocalTime getTm() {
		return tm;
	}

	public void setTm(LocalTime tm) {
		this.tm = tm;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
