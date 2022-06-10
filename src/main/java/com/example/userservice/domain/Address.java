package com.example.userservice.domain;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Embeddable
public class Address {
    private String street;
    private String city;
    private String state;
    private String zip;
    @Enumerated(EnumType.STRING)
    private AddressType type;

}
