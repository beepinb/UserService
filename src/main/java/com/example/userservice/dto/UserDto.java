package com.example.userservice.dto;

import com.example.userservice.domain.Address;
import com.example.userservice.domain.UserRole;
import com.example.userservice.dto.response.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String phoneNumber;
//    private String password;
    private List<Address> addresses;
//    private UserRole role;
    private List<Order> orders;
}
