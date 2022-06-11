package com.example.userservice.security;

import com.example.userservice.repository.UserDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserDAO userRepo;

    public UserDetailsServiceImpl(UserDAO userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Loading user with username {}",username);
        var user = userRepo.findByEmail(username);
        if (user == null) {
            log.info("User not found with username {}",username);
            throw new UsernameNotFoundException(username);
        }
        return User.withUsername(user.getEmail()).password(user.getPassword()).authorities(user.getRole().getName().name()).build();
    }
}
