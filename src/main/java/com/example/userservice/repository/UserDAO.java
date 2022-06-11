package com.example.userservice.repository;

import com.example.userservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDAO extends JpaRepository<User,Long> {

    User findByEmail(String email);
//    User findByUsername(String username);
}
