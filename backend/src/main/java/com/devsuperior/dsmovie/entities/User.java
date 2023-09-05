package com.devsuperior.dsmovie.entities;

import com.devsuperior.dsmovie.utils.Role;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String email;

	private String password;

	private LocalDateTime createdTime;
	@Enumerated(EnumType.STRING)
	private Role role;
	
	public User() {
	}

	public User(Long id, String name, String email, String password, LocalDateTime createdTime, Role role) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.createdTime = createdTime;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}
}
