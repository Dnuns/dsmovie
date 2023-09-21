package com.devsuperior.dsmovie.repositories;

import com.devsuperior.dsmovie.entities.User;
import com.devsuperior.dsmovie.utils.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository <User, Long> {
    
    User findByEmail(String email);

    @Modifying
    @Query("update User set role = :role where email = :email")
    void updateUserRole(@Param("email") String email,@Param("role") Role role);

}