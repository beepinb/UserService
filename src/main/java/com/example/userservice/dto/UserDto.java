package com.example.userservice.dto;

import com.example.userservice.domain.Address;
import com.example.userservice.domain.UserRole;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String phoneNumber;
    private String password;
    private List<Address> addresses;
    private UserRole role;
}
