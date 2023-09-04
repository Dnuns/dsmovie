package com.devsuperior.dsmovie.service;

import com.devsuperior.dsmovie.dto.UserDTO;
import com.devsuperior.dsmovie.entities.User;
import com.devsuperior.dsmovie.repositories.UserRepository;
import org.aspectj.apache.bcel.classfile.LineNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    @Transactional(readOnly = true)
    public UserDTO findByEmail(String email){

        User user = repository.findByEmail(email);

        return new UserDTO(user);
    }
}
