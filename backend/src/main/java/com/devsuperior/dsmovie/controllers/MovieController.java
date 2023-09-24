package com.devsuperior.dsmovie.controllers;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devsuperior.dsmovie.dto.MovieInsertDTO;
import com.devsuperior.dsmovie.dto.MovieReturnDTO;
import com.devsuperior.dsmovie.service.MovieService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = "/api/v1/movies")
public class MovieController {
	
	@Autowired
	private MovieService service;
	
	@GetMapping
	public ResponseEntity<Page<MovieReturnDTO>> findAll(Pageable pageable){

		Page<MovieReturnDTO> page = service.findAll(pageable);
		return ResponseEntity.ok().body(page);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<MovieReturnDTO> findById(@PathVariable Long id){

		MovieReturnDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}

	@PostMapping
	public ResponseEntity<MovieReturnDTO> saveMovie(@Valid @RequestBody MovieInsertDTO dto) {
		
		MovieReturnDTO returnDTO = service.saveMovie(dto);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			.buildAndExpand(returnDTO.getId()).toUri();
		
		return ResponseEntity.created(uri).body(returnDTO);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<MovieReturnDTO> updateMovie(@PathVariable Long id, @Valid @RequestBody MovieInsertDTO dto) throws Exception {
		
		return ResponseEntity.ok().body(service.updateMovie(id,dto));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {

		service.deleteMovie(id);
		
		return ResponseEntity.noContent().build();
	}
	
}
