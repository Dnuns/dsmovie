package com.devsuperior.dsmovie.controllers;

import com.devsuperior.dsmovie.dto.UserDTO;
import com.devsuperior.dsmovie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping(value = "/users")
@Controller
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping(value = "/{email}")
    public ResponseEntity<UserDTO> findByEmail(@Valid @PathVariable String email){
        UserDTO dto = service.findByEmail(email);

        return ResponseEntity.ok().body(dto);
    }

}
