package com.example.userservice.service;

import com.example.userservice.domain.User;
import com.example.userservice.dto.UserDto;
import com.example.userservice.repository.UserDAO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.internal.bytebuddy.description.method.MethodDescription;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.lang.reflect.Type;
import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserDAO userDAO;
    @Resource
    private ModelMapper modelMapper;

    @Override
    public List<UserDto> findAll() {
        var users= userDAO.findAll();
        Type listType = new TypeToken<List<UserDto>>() {}.getType();
        return modelMapper.map(users, listType);

    }

    @Override
    public UserDto findById(Long id) {
        User user= userDAO.findById(id).get();
        return  modelMapper.map(user,UserDto.class);
    }

    @Override
    public void add(UserDto userDto) {
        User user=modelMapper.map(userDto, User.class);
        userDAO.save(user);
    }

    @Override
    public void update(UserDto userDto) {
        var user=modelMapper.map(userDto,User.class);
        userDAO.save(user);
    }

    @Override
    public void delete(Long id) {
        userDAO.deleteById(id);
    }

}