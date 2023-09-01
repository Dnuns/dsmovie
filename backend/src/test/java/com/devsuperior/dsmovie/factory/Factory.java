package com.devsuperior.dsmovie.factory;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.dto.ScoreDTO;
import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.entities.Score;
import com.devsuperior.dsmovie.entities.User;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Factory {
     public static Movie createMovie(){

         Movie movie = new Movie();

         movie.setId(1L);
         movie.setTitle("Matrix");
         movie.setCount(0);
         movie.setScore(0.0);
         movie.setImgage(null);

        return movie;
    }

    public  static MovieDTO createMovieDto(){

       MovieDTO movieDto = new MovieDTO();

        movieDto.setId(1L);
        movieDto.setCount(0);
        movieDto.setScore(0.0);
        movieDto.setImage(null);
        movieDto.setTitle(null);

        return movieDto;
    }

    private static User createUser() {

         User user = new User();
         user.setId(3L);
         user.setEmail("joana.mendes@gmail.com");

         return user;
    }

    public static ScoreDTO createScoreDto() {
         ScoreDTO scoreDTO = new ScoreDTO();
         scoreDTO.setMovieId(Factory.createMovie().getId());
         scoreDTO.setEmail(Factory.createUser().getEmail());
         scoreDTO.setMovieId(Factory.createMovie().getId());

         return scoreDTO;
    }
}
