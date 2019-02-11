package com.mert.filmreminder.services;

import java.util.*;

import com.mert.filmreminder.domain.Film;
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

    @Override
    public User save(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public List<User> saveAll(Set<User> films) {
        final ArrayList<User> savedFilms = new ArrayList<>();
        final Iterable<User> saved = this.userRepository.saveAll(films);
        saved.forEach(savedFilms::add);
        return Collections.unmodifiableList(savedFilms);
    }


    @Override
    public User getUserByName(String name) {
        return this.userRepository.findByUsername(name).orElseThrow(() -> new IllegalArgumentException());
    }

    @Override
    public void deleteUser(User user) {
        this.userRepository.delete(user);
    }

    @Override
    public void deleteUserById(Long id) {
        this.userRepository.deleteById(id);
    }

}
