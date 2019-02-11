package com.mert.filmreminder.services;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.mert.filmreminder.domain.User;
import com.mert.filmreminder.repositories.UserRepository;

/**
 * Test class created for UserService
 *
 * @author Mert
 */
public class UserServiceTest {

    UserServiceImpl userService;

    @Mock
    UserRepository userRepository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.userService = new UserServiceImpl(this.userRepository);
    }

    @Test
    public void testGetUsers() {

        final User user = new User();
        user.setId(1L);
        final Set<User> userSet = new HashSet<User>();
        userSet.add(user);
        when(this.userRepository.findAll()).thenReturn(userSet);
        final Set<User> users = this.userService.getUsers();
        assertNotNull(users);
    }

    @Test
    public void testFindById() {
        final User user = new User();
        user.setId(1L);
        user.setUsername("Mert");
        when(this.userRepository.findById(1L)).thenReturn(Optional.of(user));
        final User foundUser = this.userService.findById(1L);
        assertNotNull(foundUser);
    }

    @Test
    public void testFindByUsername() {
        final User sasha = new User();
        sasha.setUsername("Sasha");
        sasha.setPassword("sasha123");
        sasha.setId(1L);
        when(this.userRepository.findByUsername("Sasha")).thenReturn(Optional.of(sasha));
        assertNotNull(this.userService.getUserByName("Sasha"));
    }

    @Test
    public void testDeleteByIdTest() {
        this.userService.deleteUserById(1L);
        verify(this.userRepository, times(1)).deleteById(anyLong());
    }

    @Test
    public void testDeleteUserTest() {
        User user = new User();
        this.userService.deleteUser(user);
        verify(this.userRepository, times(1)).delete(user);
    }


}
