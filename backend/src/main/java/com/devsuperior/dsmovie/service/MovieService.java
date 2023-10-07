package com.devsuperior.dsmovie.service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsmovie.dto.MovieInsertDTO;
import com.devsuperior.dsmovie.dto.MovieReturnDTO;
import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.repositories.MovieRepository;

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

	@Transactional
	public MovieReturnDTO saveMovie(MovieInsertDTO dto) {

		try {
			Movie movie = new Movie(dto);

			MovieReturnDTO returnDTO = new MovieReturnDTO(repository.save(movie));

			return returnDTO;
		} catch (EntityExistsException e) {
			throw new EntityExistsException("Entity exists");
		}
		
		
	}

	@Transactional
    public MovieReturnDTO updateMovie(Long id, @Valid MovieInsertDTO dto) throws Exception {
        
		try {
			Movie movie = repository.getById(id);
			copyDtoToEntity(dto, movie);
			movie = repository.save(movie);
			return new MovieReturnDTO(movie);
		} catch (EntityNotFoundException e) {
			throw new EntityNotFoundException("Id not found " + id);
		}
    }

	@Transactional
    public void deleteMovie(Long id) {
		try {
			
			repository.deleteById(id);;
		}
		catch (IllegalArgumentException e){
			e.getMessage();
		}
    }
	
	private void copyDtoToEntity(MovieInsertDTO dto, Movie entity) {
		
		entity.setTitle(dto.getTitle());
		entity.setImage(dto.getImage());

	}
}
