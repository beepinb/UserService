package com.example.userservice.controllers;

import com.example.userservice.dto.LoginRequest;
import com.example.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/uaa")
@CrossOrigin
public class UserLoginController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login( LoginRequest loginRequest) {
        var loginResponse = userService.login(loginRequest);
        return ResponseEntity.ok().body(loginResponse);
    }
}

