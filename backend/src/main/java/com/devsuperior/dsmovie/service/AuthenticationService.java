package com.devsuperior.dsmovie.service;

import com.devsuperior.dsmovie.entities.User;

public interface AuthenticationService {
    User SingInAndReturnJwt(User signInRequest);
}
