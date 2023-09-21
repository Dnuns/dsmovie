package com.devsuperior.dsmovie.controllers;

import com.devsuperior.dsmovie.dto.UserReturnDTO;
import com.devsuperior.dsmovie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping(value = "/users")
@Controller
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping(value = "/{email}")
    public ResponseEntity<UserReturnDTO> findByEmail(@Valid @PathVariable String email){

        UserReturnDTO dto = new UserReturnDTO(service.findByEmail(email));

        return ResponseEntity.ok().body(dto);
    }

}
