package com.devsuperior.dsmovie.service;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.factory.Factory;
import com.devsuperior.dsmovie.repositories.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.TestPropertySource;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
    private Movie movie;

    @BeforeEach
    void setUp() throws Exception {
        movie = Factory.createMovie();
    }

    @Test
    void findAllShouldReturnList(){

        page = new PageImpl<>(List.of(movie));

        when(repository.findAll((Pageable)ArgumentMatchers.any())).thenReturn(page);

        Pageable pageable = PageRequest.of(0, 12);

        Page<MovieDTO> result = service.findAll((PageRequest) pageable);

        Mockito.verify(repository, times(1)).findAll(pageable);

        assertNotNull(result);
    }

    @Test
    void findByIdShouldReturnMovieDto(){

        when(repository.findById(1L)).thenReturn(Optional.of(movie));

        MovieDTO result = service.findById(1L);

        Mockito.verify(repository, times(1)).findById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Matrix", result.getTitle());
        assertEquals(0, result.getCount());
    }

}