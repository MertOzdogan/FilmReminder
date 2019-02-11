package com.mert.filmreminder.services;

import com.mert.filmreminder.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTestIT {

    @Autowired
    UserService userService;

    @DirtiesContext
    @Transactional
    @Test
    public void save() {
        final User testUser = new User();
        testUser.setUsername("Sasha");
        testUser.setPassword("Sasha123");
        testUser.setId(13L);
        this.userService.save(testUser);
        assertNotNull(this.userService.getUserByName("Sasha"));
    }

    @DirtiesContext
    @Transactional
    @Test
    public void saveAll() {
        final User testUser = new User();
        testUser.setUsername("Sasha");
        testUser.setPassword("Sasha123");
        testUser.setId(1123L);

        final User faye = new User();
        faye.setUsername("faye");
        faye.setPassword("faye123");
        faye.setId(14L);

        Set<User> userset = new HashSet<>();
        userset.add(testUser);
        userset.add(faye);
        this.userService.saveAll(userset);

        assertNotNull(this.userService.getUserByName("Sasha"));
        assertNotNull(this.userService.getUserByName("faye"));

    }
}