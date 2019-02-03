package com.mert.filmreminder.services;

import static org.junit.Assert.assertNotNull;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.mert.filmreminder.domain.Film;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FilmServiceIT {

	@Autowired
	FilmService filmService;

	@DirtiesContext
	@Transactional
	@Test
	public void saveTest() {
		final Film testFilm = new Film();
		testFilm.setDescription("Some example descrip for the test film.");
		testFilm.setName("Test film");
		testFilm.setLength(13L);
		this.filmService.save(testFilm);
		assertNotNull(this.filmService.getFilmByName("Test film"));
	}

	@DirtiesContext
	@Transactional
	@Test
	public void saveAllTest() {
		final Film testFilm = new Film();
		testFilm.setDescription("Some example descrip for the test film.");
		testFilm.setName("Test film");
		testFilm.setLength(13L);
		final Film secondTestFilm = new Film();
		secondTestFilm.setDescription(
				"Some example descrip for the test film. The first one was so good so 2nd one is out now!");
		secondTestFilm.setName("Test film -2");
		secondTestFilm.setLength(13L);

		final Set<Film> filmSet = new HashSet<>();
		filmSet.add(testFilm);
		filmSet.add(secondTestFilm);

		this.filmService.saveAll(filmSet);
		assertNotNull(this.filmService.getFilmById(testFilm.getId()));
		assertNotNull(this.filmService.getFilmById(secondTestFilm.getId()));
	}

}
