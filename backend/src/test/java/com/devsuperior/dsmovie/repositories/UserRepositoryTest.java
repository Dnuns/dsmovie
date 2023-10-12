package com.devsuperior.dsmovie.repositories;

import com.devsuperior.dsmovie.entities.User;
import com.devsuperior.dsmovie.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.devsuperior.dsmovie.utils.Role.*;
import static org.junit.jupiter.api.Assertions.*;


@TestPropertySource("/application-test.properties")
@SpringBootTest
class UserRepositoryTest {
    
    @Autowired
    private UserRepository repository;

    @Autowired
    private UserService service;

    @Test
    void findByEmailShouldReturnUserWhenEmailExists(){
        
        User user = repository.findByEmail("maria.123@gmail.com");

        assertNotNull(user.getEmail());
        assertEquals("maria.123@gmail.com",user.getEmail());
    }

    @Test
    void findByEmailShouldReturnNullWhenEmailDoesNotExist(){

        User user = repository.findByEmail("bertelano@gmail.com");

        assertNull(user);
    }

    @Transactional
    @Test
    void updateUserRoleShouldUpdateRoleWhenDifferent(){

       User maria = repository.getById(1L);

       repository.updateUserRole(USER, "maria.123@gmail.com");

       assertEquals(USER, maria.getRole());
    }

}