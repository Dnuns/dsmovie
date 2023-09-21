package com.devsuperior.dsmovie.service;

import com.devsuperior.dsmovie.entities.User;
import com.devsuperior.dsmovie.security.UserPrinciple;
import com.devsuperior.dsmovie.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    JwtProvider jwtProvider;

    @Override
    public User SingInAndReturnJwt(User signInRequest){

        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(signInRequest.getEmail(), signInRequest.getPassword())
        );

        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();

        String jtw = jwtProvider.generateToken(userPrinciple);

        User signInUser = userPrinciple.getUser();
        signInUser.setToken(jtw);

        return signInUser;
    }

}
