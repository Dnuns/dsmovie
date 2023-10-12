package com.devsuperior.dsmovie.controllers;

import com.devsuperior.dsmovie.dto.UserInsertDTO;
import com.devsuperior.dsmovie.dto.UserReturnDTO;
import com.devsuperior.dsmovie.entities.User;
import com.devsuperior.dsmovie.service.AuthenticationService;
import com.devsuperior.dsmovie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class AuthenticationController {
    
    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private UserService userService;

    @PostMapping(value = "/sign-up")
    public ResponseEntity<UserReturnDTO> signup(@RequestBody UserInsertDTO userInsertDto){


        if(userService.findByEmail(userInsertDto.getEmail()) != null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(userService.saveUser(userInsertDto),HttpStatus.CREATED);
    }
    
    @PostMapping(value = "/sign-in")
    public ResponseEntity<UserReturnDTO> signin(@RequestBody User user){

        UserReturnDTO dto = new UserReturnDTO(authenticationService.SingInAndReturnJwt(user));

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

}
