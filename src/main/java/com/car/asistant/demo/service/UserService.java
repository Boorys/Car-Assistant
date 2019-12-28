package com.car.asistant.demo.service;

import com.car.asistant.demo.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {

    UserDto getUser(String email);
    UserDto createUser(UserDto user);
    UserDto getUserByUserId(String userId);

}
