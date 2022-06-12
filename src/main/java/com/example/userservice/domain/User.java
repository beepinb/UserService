package com.example.userservice.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name="users")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
//    @Column(unique = true)
    private String username;
//    @Column(unique = true)
    private String email;
    private String phoneNumber;
    private String password;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Address> addresses=new ArrayList<>();
    @OneToOne(cascade = CascadeType.PERSIST)
    private UserRole role;



}
