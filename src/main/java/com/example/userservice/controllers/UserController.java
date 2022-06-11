package com.example.userservice.controllers;

import com.example.userservice.dto.UserDto;
import com.example.userservice.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {

    @Resource
    private UserService userService;


    @GetMapping("")
    public List<UserDto> getAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserDto getOne(@PathVariable Long id){
        UserDto userDto = userService.findById(id);
        return userDto;
    }

    @PostMapping("")
    public void add(@RequestBody UserDto user){
        userService.add(user);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody UserDto user,@PathVariable Long id){
        user.setId(id);
        userService.update(user);
    }

    @DeleteMapping("/{id}")
    public void deleteOne(@PathVariable Long id){
        userService.delete(id);
    }
}
