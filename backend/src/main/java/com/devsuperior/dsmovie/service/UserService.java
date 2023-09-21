package com.devsuperior.dsmovie.service;

import com.devsuperior.dsmovie.dto.UserInsertDTO;
import com.devsuperior.dsmovie.dto.UserReturnDTO;
import com.devsuperior.dsmovie.entities.User;
import com.devsuperior.dsmovie.repositories.UserRepository;
import com.devsuperior.dsmovie.utils.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public User findByEmail(String email){

        return repository.findByEmail(email);
    }

    @Transactional
    public UserReturnDTO saveUser(UserInsertDTO userInsertDTO) {

        User user = new User();

        user.setName(userInsertDTO.getName());
        user.setEmail(userInsertDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userInsertDTO.getPassword()));
        user.setRole(Role.USER);
        user.setCreatedTime(LocalDateTime.now());

        return new UserReturnDTO(repository.save(user));
    }

    public void changeRole(Role newRole, String email){
        repository.updateUserRole(email, newRole);
    }
}
