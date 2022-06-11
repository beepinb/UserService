package com.example.userservice.dto;

import com.example.userservice.domain.AddressType;
import com.example.userservice.domain.User;
import lombok.Data;


@Data
public class AddressDto {
    private Long id;
    private String street;
    private String city;
    private String state;
    private String zip;
    private AddressType type;
    private User user;
}
