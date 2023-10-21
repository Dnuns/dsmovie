package com.devsuperior.dsmovie.service;

import com.devsuperior.dsmovie.dto.MovieInsertDTO;
import com.devsuperior.dsmovie.dto.MovieReturnDTO;
import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.factory.Factory;
import com.devsuperior.dsmovie.repositories.MovieRepository;

import org.aspectj.weaver.ast.Instanceof;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@TestPropertySource("/application-test.properties")
@SpringBootTest
class MovieServiceTest {

    @InjectMocks
    private MovieService service;

    @Mock
    private MovieRepository repository;

    private PageImpl page;
    private Movie movie1;
    private Movie movie2;

    @BeforeEach
    void setUp() throws Exception {
        movie1 = Factory.createMovie1();
        movie2 = Factory.createMovie2();
    }

    @Test
    void findAllShouldReturnList(){

        page = new PageImpl<>(List.of(movie1));

        when(repository.findAll((Pageable)ArgumentMatchers.any())).thenReturn(page);

        Pageable pageable = PageRequest.of(0, 20);

        Page<MovieReturnDTO> result = service.findAll((PageRequest) pageable);

        Mockito.verify(repository, times(1)).findAll(pageable);

        assertNotNull(result);
    }

    @Test
    void findByIdShouldReturnMovieDtoWhenIdExists(){

        when(repository.findById(1L)).thenReturn(Optional.of(movie1));

        MovieReturnDTO result = service.findById(1L);

        Mockito.verify(repository, times(1)).findById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Matrix", result.getTitle());
        assertEquals(0, result.getCount());
    }

    @Test
    void findByIdShouldThrowNoSuchElementExceptionWhenIdDoesNotExit(){

        try {
            service.findById(1000l);
            fail("Exception not thrown");
        } catch (NoSuchElementException e) {
            assertEquals("No value present", e.getMessage());
        }

    }
}