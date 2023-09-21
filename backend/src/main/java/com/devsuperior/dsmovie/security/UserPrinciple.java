package com.devsuperior.dsmovie.security;

import com.devsuperior.dsmovie.entities.User;
import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Set;
@Builder
public class UserPrinciple implements UserDetails {

    private Long id;
    private String name;
    private String email;
    transient private String password; //transient -> doesn't show on serialized items

    transient private User user;

    private Set<GrantedAuthority> authorities;

    public UserPrinciple(Long id, String name, String email, String password, User user, Set<GrantedAuthority> authorities) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.user = user;
        this.authorities = authorities;
    }

    public UserPrinciple() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public User getUser() {
        return user;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
