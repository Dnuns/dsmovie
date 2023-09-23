package com.devsuperior.dsmovie.dto;

import com.devsuperior.dsmovie.entities.Movie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieReturnDTO {
	
	private Long id;
	
	@NotBlank
	private String title;
	
	private Double score;
	
	private Integer count;
	
	@NotBlank
	@URL
	private String image;

	public MovieReturnDTO(Movie movie) {
		id = movie.getId();
		title = movie.getTitle();
		score = movie.getScore();
		count = movie.getCount();
		image = movie.getImage();
	}
}
