/**
 *
 */
package com.mert.filmreminder.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mert.filmreminder.domain.Film;

/**
 * @author Mert
 */
public interface FilmRepository extends CrudRepository<Film, Long> {

}
