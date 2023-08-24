package com.devsuperior.dsmovie.factory;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.entities.Movie;

public class Factory {
     public static Movie createMovie(){

         Movie movie = new Movie();

        movie.setId(1L);
        movie.setTitle("Matrix");
        movie.setCount(0);
        movie.setScore(0.0);
        movie.setScores(null);
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
}
