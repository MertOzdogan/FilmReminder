package com.mert.filmreminder.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.mert.filmreminder.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

	@Override
	Optional<User> findById(Long id);
	Optional<User> findByUsername(String username);
}
