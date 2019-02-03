package com.mert.filmreminder.services;

import java.util.List;
import java.util.Set;

import com.mert.filmreminder.domain.Film;

public interface FilmService {

	Set<Film> getFilms();

	Film getFilmById(Long id);

	Film save(Film film);

	List<Film> saveAll(Set<Film> films);

	Film getFilmByName(String name);

	void deleteFilm(Film film);

	void deleteFilmById(Long id);
}
