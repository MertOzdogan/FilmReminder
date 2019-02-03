package com.mert.filmreminder.services;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.mert.filmreminder.domain.Film;
import com.mert.filmreminder.repositories.FilmRepository;

/**
 * Test class for {@link FilmService}
 *
 * @author Mert
 *
 */
public class FilmServiceTest {

	FilmService filmService;
	@Mock
	FilmRepository filmRepository;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.filmService = new FilmServiceImpl(this.filmRepository);
	}

	@Test
	public void getByIdTest() {
		final Film sashasTrouble = new Film();
		sashasTrouble.setId(333L);
		sashasTrouble.setDescription("Sasha is having some trouble with more than 9 people.");
		sashasTrouble.setName("Sashas Trouble");

		when(this.filmRepository.findById(any())).thenReturn(Optional.of(sashasTrouble));
		assertNotNull(this.filmService.getFilmById(any()));

	}

	@Test
	public void getAllFilmsTest() {
		final Film sashasTrouble = new Film();
		sashasTrouble.setId(333L);
		sashasTrouble.setDescription("Sasha is having some trouble with more than 9 people.");
		sashasTrouble.setName("Sashas Trouble");
		final Set<Film> mockFilmset = new HashSet<>();
		mockFilmset.add(sashasTrouble);

		when(this.filmRepository.findAll()).thenReturn(mockFilmset);

		final Set<Film> filmsByService = this.filmService.getFilms();
		assertNotNull(filmsByService);
	}

	@Test
	public void getByNameTest() {
		final Film sashasTrouble = new Film();
		sashasTrouble.setId(any());
		sashasTrouble.setName("Sashas Trouble");
		when(this.filmRepository.findByName("Sashas Trouble")).thenReturn(Optional.of(sashasTrouble));
		assertNotNull(this.filmService.getFilmByName("Sashas Trouble"));
	}

	@Test
	public void deleteByIdTest() { // given
		final Long idToDelete = Long.valueOf(2L);

		// when
		this.filmService.deleteFilmById(idToDelete);

		// no 'when', since method has void return type

		// then
		verify(this.filmRepository, times(1)).deleteById(anyLong());

	}

	@Test
	public void deleteFilmTest() {
		// given
		final Film filmToDelete = new Film();
		// when
		this.filmService.deleteFilm(filmToDelete);

		// then
		verify(this.filmRepository, times(1)).delete(filmToDelete);

	}
}
