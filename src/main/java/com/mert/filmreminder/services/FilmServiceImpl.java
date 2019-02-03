package com.mert.filmreminder.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
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

	@Override
	public Film save(final Film film) {
		return this.filmRepository.save(film);
	}

	@Override
	public Film getFilmByName(final String name) {
		return this.filmRepository.findByName(name).orElseThrow(() -> new IllegalArgumentException());
	}

	@Override
	public List<Film> saveAll(final Set<Film> films) {

		final ArrayList<Film> savedFilms = new ArrayList<>();
		final Iterable<Film> saved = this.filmRepository.saveAll(films);
		saved.forEach(savedFilms::add);
		return Collections.unmodifiableList(savedFilms);

	}

	@Override
	public void deleteFilm(final Film film) {
		this.filmRepository.delete(film);
	}

	@Override
	public void deleteFilmById(final Long id) {
		this.filmRepository.deleteById(id);
	}

}
