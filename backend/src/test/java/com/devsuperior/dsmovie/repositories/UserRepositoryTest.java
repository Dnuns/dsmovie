package com.devsuperior.dsmovie.repositories;

import com.devsuperior.dsmovie.entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@TestPropertySource("/application-test.properties")
@SpringBootTest
class UserRepositoryTest {
    
    @Autowired
    private UserRepository repository;

    @Test
    void findByEmailShouldReturnUser(){
        User user = repository.findByEmail("maria.123@gmail.com");

        assertNotNull(user.getEmail());
        assertEquals("maria.123@gmail.com",user.getEmail());
    }
}