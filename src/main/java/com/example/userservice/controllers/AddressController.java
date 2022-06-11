package com.example.userservice.controllers;


import com.example.userservice.dto.AddressDto;
import com.example.userservice.service.AddressService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users/{user_id}/address")
public class AddressController {
    @Resource
    private AddressService addressService;


    @GetMapping()
    public List<AddressDto> getAll(@PathVariable Long user_id) {
        return addressService.findAll(user_id);
    }


    @GetMapping("/{address_id}")
    public AddressDto getOne(@PathVariable Long user_id, @PathVariable Long address_id) {
        Object addressDto = addressService.findById(user_id, address_id);
        return (AddressDto) addressDto;
    }


    @PostMapping()
    public void add(@RequestBody AddressDto address, @PathVariable Long user_id) {
        addressService.add(user_id, address);
    }
}
