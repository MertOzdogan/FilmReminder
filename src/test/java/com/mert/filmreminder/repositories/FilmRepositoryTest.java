package com.mert.filmreminder.repositories;


import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mert.filmreminder.domain.Film;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@RunWith(SpringRunner.class)
public class FilmRepositoryTest {

	@Autowired
	FilmRepository filmRepository;

	@Test
	public void findByIdTest() {
		final Optional<Film> findByDescription = this.filmRepository.findById(1L);
		Film film =findByDescription.get();

		assertEquals("Sashas Dream", findByDescription.get().getName(), () -> "Film is not equal.");
	}

	@Test
	public void findByNameTest() {
		final Optional<Film> findByDescription = this.filmRepository.findByName("Sashas Dream");
		assertEquals(1l, findByDescription.get().getId().longValue(), () -> "Film is not equal.");
	}

	@Test
	public void findByDescriptionTest() {
		final Optional<Film> findByDescription = this.filmRepository
				.findByDescription("Some gunshot and all you know.");
		assertEquals("Sashas Dream", findByDescription.get().getName(), () -> "Film is not equal.");
	}
}
