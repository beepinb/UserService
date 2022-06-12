package com.example.userservice;

import com.example.userservice.domain.*;
import com.example.userservice.dto.UserDto;
import com.example.userservice.repository.UserDAO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
@FeignClient
public class UserServiceApplication implements CommandLineRunner {
    @Autowired
    private UserDAO userDAO;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Override
    public void run(String... args) throws Exception {

        UserRole adminRole=new UserRole(null, RoleType.ADMIN);

        List<Address> address1= Arrays.asList(new Address(null,"1000 N","Fairfield","Iowa","67253", AddressType.BILLING));
        User user1=new User(null,"ram","bahadur","ramey","ram@test.com","34453453","123",address1,adminRole);

        User user=modelMapper().map(user1, User.class);
        user.setPassword(passwordEncoder().encode(user1.getPassword()));
        userDAO.save(user);

    }
}
