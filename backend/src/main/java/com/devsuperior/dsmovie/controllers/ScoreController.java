package com.devsuperior.dsmovie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmovie.dto.MovieReturnDTO;
import com.devsuperior.dsmovie.dto.ScoreDTO;
import com.devsuperior.dsmovie.service.ScoreService;

import springfox.documentation.annotations.ApiIgnore;


@ApiIgnore
@RestController
@RequestMapping(value = "/api/v1/scores")
public class ScoreController {
	
	@Autowired
	private ScoreService service;
	
	@PutMapping
	public ResponseEntity<MovieReturnDTO> saveScore(@RequestBody ScoreDTO dto){

		MovieReturnDTO result = service.saveScore(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}
}
