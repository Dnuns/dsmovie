package com.devsuperior.dsmovie.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_movie")
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private Double score;
	private Integer count;
	private String image;
	
	@OneToMany(mappedBy = "id.movie")
	private Set<Score> scores = new HashSet<>();
	
	public Movie() {
		
	}

	public Movie(Long id, String title, Double score, Integer count, String imgage) {
		this.id = id;
		this.title = title;
		this.score = score;
		this.count = count;
		this.image = imgage;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getImgage() {
		return image;
	}

	public void setImgage(String imgage) {
		this.image = imgage;
	}
	
	public Set<Score> getScores() {
		return scores;
	}
	
	public void setScores(Set<Score> scores) {
		this.scores = scores;
	}
}
