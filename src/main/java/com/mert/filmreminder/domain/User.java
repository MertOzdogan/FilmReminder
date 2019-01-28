package com.mert.filmreminder.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String password;

	@OneToMany
	private Set<Film> watchedFilm = new HashSet<>();
	@OneToMany
	private Set<Film> willingToWatchFilms = new HashSet<>();
}
