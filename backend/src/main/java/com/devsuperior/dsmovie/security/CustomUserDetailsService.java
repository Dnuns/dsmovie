package com.devsuperior.dsmovie.security;

import com.devsuperior.dsmovie.entities.User;
import com.devsuperior.dsmovie.service.UserService;
import com.devsuperior.dsmovie.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    
    @Autowired
    private UserService service;
    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = service.findByEmail(email);

        Set<GrantedAuthority> authorities = Set.of(SecurityUtils.convertToAuthority(user.getRole().name()));

        return UserPrinciple.builder()
                .user(user)
                .id(user.getId())
                .name(user.getName())
                .password(user.getPassword())
                .email(user.getEmail())
                .authorities(authorities)
                .build();

    }
}