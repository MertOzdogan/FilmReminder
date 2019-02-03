package com.mert.filmreminder.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String password;

	@ManyToMany(mappedBy = "usersWatched")
	private Set<Film> watchedFilm = new HashSet<>();
	@ManyToMany(mappedBy = "usersWillWatch")
	private Set<Film> willingToWatchFilms = new HashSet<>();
}
