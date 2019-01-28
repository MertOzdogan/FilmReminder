/**
 *
 */
package com.mert.filmreminder.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.mert.filmreminder.domain.Film;

/**
 * @author Mert
 */
public interface FilmRepository extends CrudRepository<Film, Long> {

	@Override
	Optional<Film> findById(Long id);
	Optional<Film> findByName(String name);
	Optional<Film> findByDescription(String description);

}
