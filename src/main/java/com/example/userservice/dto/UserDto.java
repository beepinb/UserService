package com.example.userservice.dto;

import com.example.userservice.domain.Address;
import com.example.userservice.domain.UserRole;
import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Address address;

    private List<UserRole> roles;
}
