package com.mert.filmreminder.services;

import java.util.Set;

import com.mert.filmreminder.domain.Film;

public interface FilmService {

	Set<Film> getFilms();

	Film getFilmById(Long id);
}
