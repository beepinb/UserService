package com.example.userservice.service;

import com.example.userservice.dto.AddressDto;

import java.util.List;

public interface AddressService {

    public List<AddressDto> findAll(Long id);  //
    public AddressDto findById(Long userId,Long addressId);//
    public void add(Long id,AddressDto addressDto); //

    //
//    public void update(S s); //
//    public void delete(Long id);  //
//}
}
