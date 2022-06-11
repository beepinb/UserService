package com.example.userservice.service;

import com.example.userservice.domain.Address;
import com.example.userservice.dto.AddressDto;
import com.example.userservice.repository.AddressDAO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.lang.reflect.Type;
import java.util.List;
@Service
@Transactional
public class AddressServiceImpl implements AddressService{

    @Resource
    private AddressDAO addressDAO;
    @Resource
    private ModelMapper modelMapper;
    @Override
    public List<AddressDto> findAll(Long id) {
        List<Address> address=addressDAO.findAllAddresses(id);
        Type listType=new TypeToken<List<AddressDto>>(){}.getType();
        return modelMapper.map(address,listType);
    }

    @Override
    public AddressDto findById(Long userId,Long addressId) {
        Address address=addressDAO.findAddressById(userId,addressId);
        return modelMapper.map(address,AddressDto.class);

    }

//
    @Override
    public void add(Long id, AddressDto addressDto) {
        Address address=modelMapper.map(addressDto,Address.class);
//        address.setUser(addressDto.getUser());
        addressDAO.save(address);


    }
//
//    @Override
//    public void update(AddressDto addressDto) {
//        Address address=modelMapper.map(addressDto,Address.class);
//        addressDAO.save(address);
//
//    }
//
//    @Override
//    public void delete(Long id) {
//        addressDAO.deleteById(id);
//
//    }
}
