package com.mert.filmreminder.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.mert.filmreminder.domain.Film;
import com.mert.filmreminder.repositories.FilmRepository;

@Service
public class FilmServiceImpl implements FilmService {

	FilmRepository filmRepository;

	public FilmServiceImpl(final FilmRepository filmRepository) {
		this.filmRepository = filmRepository;
	}

	@Override
	public Set<Film> getFilms() {
		final Set<Film> filmSet = new HashSet<>();
		this.filmRepository.findAll().iterator().forEachRemaining(filmSet::add);
		return filmSet;
	}

	@Override
	public Film getFilmById(final Long id) {

		return this.filmRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());

	}

}
