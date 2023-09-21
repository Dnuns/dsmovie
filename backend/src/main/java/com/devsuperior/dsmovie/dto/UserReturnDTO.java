package com.devsuperior.dsmovie.dto;

import com.devsuperior.dsmovie.entities.User;
import com.devsuperior.dsmovie.utils.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserReturnDTO {

    private Long id;

    private String name;

    private String email;

    private Role role;

    private LocalDateTime createdTime;

    private String token;

    public UserReturnDTO(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.role = user.getRole();
        this.createdTime = user.getCreatedTime();
        this.token = user.getToken();
    }
}
