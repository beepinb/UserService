package com.example.userservice.service;

import com.example.userservice.domain.User;
import com.example.userservice.dto.LoginRequest;
import com.example.userservice.dto.UserDto;
import com.example.userservice.dto.response.LoginResponse;
import com.example.userservice.dto.response.Order;
import com.example.userservice.exception.UserAlreadyFoundException;
import com.example.userservice.exception.UserNotFoundException;
import com.example.userservice.feigndata.OrderClient;
import com.example.userservice.repository.UserDAO;
import com.example.userservice.security.JwtHelper;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.lang.reflect.Type;
import java.util.List;

@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {
    @Resource
    private UserDAO userDAO;
    @Resource

    private ModelMapper modelMapper;
    @Resource

    private PasswordEncoder passwordEncoder;
    @Resource

    private AuthenticationManager authenticationManager;
    @Resource

    private JwtHelper jwtHelper;

    @Resource
    private OrderClient orderClient;


    @Override
    public List<UserDto> findAll() {
        var users = userDAO.findAll();
        Type listType = new TypeToken<List<UserDto>>() {
        }.getType();
        return modelMapper.map(users, listType);

    }

    @Override
    public UserDto findById(Long id) {
        User user = userDAO.findById(id).get();
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public void add(User newUser) throws UserAlreadyFoundException {
        if (userDAO.existsByEmail(newUser.getEmail())) {
            throw new UserAlreadyFoundException("User with this email already exists");
        }
        var address = newUser.getAddresses();
        User user = modelMapper.map(newUser, User.class);
        user.setPassword(passwordEncoder.encode(newUser.getPassword()));
        userDAO.save(user);

    }

    @Override
    public void update(User updatedUser) {
//        var user=modelMapper.map(updatedUser,User.class);
        userDAO.save(updatedUser);
    }

    @Override
    public void delete(Long id) {
        userDAO.deleteById(id);
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        Authentication authentication = null;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                            loginRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new UserNotFoundException("Bad Credentials");
        }
        String role = authentication.getAuthorities().stream().findFirst().get().getAuthority();
        final String accessToken = jwtHelper.generateToken(loginRequest.getEmail(), role);
        final String refreshToken = jwtHelper.generateRefreshToken(loginRequest.getEmail());
        var loginResponse = new LoginResponse(accessToken, refreshToken);
        return loginResponse;
    }

    @Override
    public UserDto findUserDetails(Long id) {
        var users = userDAO.findAll();
        Type listType = new TypeToken<List<UserDto>>() {
        }.getType();
        UserDto userDto = modelMapper.map(users, listType);
        List<Order> orders = orderClient.getOrder(id);
        userDto.setOrders(orders);
        return userDto;
    }

}