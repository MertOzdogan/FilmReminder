package com.mert.filmreminder.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.mert.filmreminder.domain.User;
import com.mert.filmreminder.repositories.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	UserRepository userRepository;

	public UserServiceImpl(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public Set<User> getUsers() {
		final Set<User> userSet = new HashSet<User>();
		this.userRepository.findAll().iterator().forEachRemaining(userSet::add);
		return userSet;
	}

	@Override
	public User findById(final Long id) {
		return this.userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
	}

}
