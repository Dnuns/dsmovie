package com.devsuperior.dsmovie.service;

import com.devsuperior.dsmovie.dto.MovieReturnDTO;
import com.devsuperior.dsmovie.dto.ScoreDTO;
import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.entities.Score;
import com.devsuperior.dsmovie.entities.User;
import com.devsuperior.dsmovie.factory.Factory;
import com.devsuperior.dsmovie.repositories.MovieRepository;
import com.devsuperior.dsmovie.repositories.ScoreRepository;
import com.devsuperior.dsmovie.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

}