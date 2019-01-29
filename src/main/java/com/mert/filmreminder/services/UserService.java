package com.mert.filmreminder.services;

import java.util.Set;

import com.mert.filmreminder.domain.User;

public interface UserService {

	Set<User> getUsers();

	User findById(Long id);

}
