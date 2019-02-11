package com.mert.filmreminder.services;

import java.util.List;
import java.util.Set;

import com.mert.filmreminder.domain.Film;
import com.mert.filmreminder.domain.User;

public interface UserService {

    Set<User> getUsers();

    User findById(Long id);

    User save(User user);

    List<User> saveAll(Set<User> films);

    User getUserByName(String name);

    void deleteUser(User user);

    void deleteUserById(Long id);
}
