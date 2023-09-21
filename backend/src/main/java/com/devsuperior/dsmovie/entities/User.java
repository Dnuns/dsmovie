package com.devsuperior.dsmovie.entities;

import com.devsuperior.dsmovie.dto.UserInsertDTO;
import com.devsuperior.dsmovie.dto.UserReturnDTO;
import com.devsuperior.dsmovie.utils.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@Column(unique = true)
	private String email;

	private String password;

	private LocalDateTime createdTime;

	@Enumerated(EnumType.STRING)
	private Role role;

	@Transient
	private String token;

	public User(UserInsertDTO userInsertDTO) {
		this.id = userInsertDTO.getId();
		this.name = userInsertDTO.getName();
		this.email = userInsertDTO.getEmail();
		this.password = userInsertDTO.getPassword();
		this.createdTime = LocalDateTime.now();
		this.role = Role.USER;
	}
}
