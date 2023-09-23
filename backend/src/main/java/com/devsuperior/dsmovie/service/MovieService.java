package com.devsuperior.dsmovie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsmovie.dto.MovieInsertDTO;
import com.devsuperior.dsmovie.dto.MovieReturnDTO;
import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.repositories.MovieRepository;

import net.bytebuddy.implementation.bytecode.Throw;

@Service
public class MovieService {

	@Autowired
	private MovieRepository repository;
	
	@Transactional(readOnly = true)
	public Page<MovieReturnDTO> findAll(Pageable pageable){
		Page<Movie> result = repository.findAll(pageable);
		Page<MovieReturnDTO> page = result.map(x -> new MovieReturnDTO(x));
		return page;
	}
	
	@Transactional(readOnly = true)
	public MovieReturnDTO findById(Long id){
		Movie result = repository.findById(id).orElseThrow();
		MovieReturnDTO dto = new MovieReturnDTO(result); 
		return dto;
	}

	public MovieReturnDTO saveMovie(MovieInsertDTO dto) {
		
		Movie movie = new Movie(dto);

		MovieReturnDTO returnDTO = new MovieReturnDTO(repository.save(movie));

		return returnDTO;
	}
}
