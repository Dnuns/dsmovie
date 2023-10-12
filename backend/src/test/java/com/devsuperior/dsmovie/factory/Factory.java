package com.devsuperior.dsmovie.factory;

import com.devsuperior.dsmovie.dto.MovieReturnDTO;
import com.devsuperior.dsmovie.dto.ScoreDTO;
import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.entities.User;

public class Factory {

    public static Movie createMovie1(){

         Movie movie = new Movie();

         movie.setId(1L);
         movie.setTitle("Matrix");
         movie.setCount(0);
         movie.setScore(0.0);
         movie.setImage("https://www.themoviedb.org/t/p/w533_and_h300_bestv2/hv7o3VgfsairBoQFAawgaQ4cR1m.jpg");

        return movie;
    }

    public static Movie createMovie2(){

        Movie movie = new Movie();

        movie.setId(2L);
        movie.setTitle("Tartarugas Ninja: Caos Mutante");
        movie.setCount(0);
        movie.setScore(0.0);
        movie.setImage("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/n3M5gSOjWYxFakAsGbi6OFFi4LZ.jpg");

        return movie;
    }

    public  static MovieReturnDTO createMovieDto(){

       MovieReturnDTO movieDto = new MovieReturnDTO();

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
         scoreDTO.setMovieId(Factory.createMovie1().getId());
         scoreDTO.setEmail(Factory.createUser().getEmail());
         scoreDTO.setMovieId(Factory.createMovie1().getId());

         return scoreDTO;
    }
}
