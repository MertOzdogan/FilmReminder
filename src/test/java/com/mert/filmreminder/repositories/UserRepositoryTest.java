package com.mert.filmreminder.repositories;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mert.filmreminder.domain.User;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

	@Autowired
	UserRepository userRepository;

	@Test
	public void findByIdTest() {
		final Optional<User> findByUsername = this.userRepository.findById(1L);
		assertEquals("Mert", findByUsername.get().getUsername());
	}

	@Test
	public void findByNameTest() {
		final Optional<User> findByUsername = this.userRepository.findByUsername("Mert");
		assertEquals("Mert", findByUsername.get().getUsername());
	}

}
