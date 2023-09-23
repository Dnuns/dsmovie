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
public class MovieInsertDTO {

	@NotBlank
	private String title;

	@NotBlank
	@URL
	private String image;
}
