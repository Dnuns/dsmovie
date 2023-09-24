package com.devsuperior.dsmovie.entities;

import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.devsuperior.dsmovie.dto.MovieInsertDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_movie")
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String title;
	
	private Double score;
	
	private Integer count;
	
	private String image;
	
	@OneToMany(mappedBy = "id.movie", cascade = CascadeType.ALL)
	private Set<Score> scores = new HashSet<>();

	public Movie(MovieInsertDTO dto){
		this.id = null;
		this.title = dto.getTitle();
		this.score = 0.0;
		this.count = 0;
		this.image = dto.getImage();
	}
	
}
