package com.devsuperior.dsmovie.dto;

import com.devsuperior.dsmovie.entities.User;
import com.devsuperior.dsmovie.utils.Role;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class UserDTO {

    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    @Email
    private String email;

    private LocalDateTime createdTime;
    @NotBlank
    private Role role;

    public UserDTO() {
    }

    public UserDTO(Long id, String name, String email, LocalDateTime createdTime, Role role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.createdTime = createdTime;
        this.role = role;
    }

    public UserDTO(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
