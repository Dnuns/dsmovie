package com.devsuperior.dsmovie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmovie.dto.MovieReturnDTO;
import com.devsuperior.dsmovie.service.MovieService;

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
}
