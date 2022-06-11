package com.example.userservice.service;

import com.example.userservice.domain.User;
import com.example.userservice.dto.LoginRequest;
import com.example.userservice.dto.UserDto;
import com.example.userservice.dto.response.LoginResponse;

import java.util.List;

public interface UserService extends BaseService<UserDto,Long> {
    LoginResponse login(LoginRequest loginRequest);

}
