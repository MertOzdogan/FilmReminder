package com.mert.filmreminder.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mert.filmreminder.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
