package com.devsuperior.dsmovie.controllers;

import com.devsuperior.dsmovie.dto.UserInsertDTO;
import com.devsuperior.dsmovie.dto.UserReturnDTO;
import com.devsuperior.dsmovie.security.UserPrinciple;
import com.devsuperior.dsmovie.service.UserService;
import com.devsuperior.dsmovie.utils.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;


@Controller
@RequestMapping(value = "/api/v1/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping(value = "/{email}")
    public ResponseEntity<UserReturnDTO> findByEmail(@Valid @PathVariable String email){

        UserReturnDTO dto = new UserReturnDTO(service.findByEmail(email));

        return ResponseEntity.ok().body(dto);
    }

    @ApiIgnore
    @PutMapping(value = "/change/{role}")
    public ResponseEntity<?> changeRole(@PathVariable Role role, @AuthenticationPrincipal UserPrinciple userPrinciple){

        service.changeRole(role, userPrinciple.getEmail());
        
        return ResponseEntity.ok().body("Role updated to " + role);
    }

    @ApiIgnore
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){

        service.deleteUser(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserReturnDTO> updateUser(@PathVariable Long id, @Valid @RequestBody UserInsertDTO dto){
        return ResponseEntity.ok().body(service.updateUser(id, dto));
    }

}
