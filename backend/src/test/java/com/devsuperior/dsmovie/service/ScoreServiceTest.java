package com.devsuperior.dsmovie.service;

import com.devsuperior.dsmovie.dto.MovieReturnDTO;
import com.devsuperior.dsmovie.dto.ScoreDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@TestPropertySource("/application-test.properties")
class ScoreServiceTest {
    @Autowired
    private ScoreService scoreService;

    @Test
    void saveScoreShouldPersistValue(){

        ScoreDTO scoreDTO = new ScoreDTO();
        scoreDTO.setEmail("carlos.123@gmail.com");
        scoreDTO.setScore(5.0);
        scoreDTO.setMovieId(1L);

        MovieReturnDTO movieDTO = scoreService.saveScore(scoreDTO);

        assertEquals(1L, scoreDTO.getMovieId());
        assertEquals(2.5, movieDTO.getScore());
        assertEquals(2, movieDTO.getCount());
        assertEquals("carlos.123@gmail.com",scoreDTO.getEmail());
    }

    @Test
    void saveScoreShouldThrowNoSuchElementExceptionWhenIdDoesNotExit(){

        ScoreDTO scoreDTO = new ScoreDTO();
        scoreDTO.setEmail("carlos.123@gmail.com");
        scoreDTO.setScore(5.0);
        scoreDTO.setMovieId(1000L);

        try {

            scoreService.saveScore(scoreDTO);
            fail("Exception not thrown");

        } catch (NoSuchElementException e) {

            assertEquals("No value present", e.getMessage());
        }
    }

}