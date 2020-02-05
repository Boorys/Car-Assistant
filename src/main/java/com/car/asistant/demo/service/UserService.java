package com.car.asistant.demo.service;

import com.car.asistant.demo.entity.UserEntity;
import com.car.asistant.demo.request.UserPostDto;
import com.car.asistant.demo.response.UserGetDto;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {

    UserGetDto getUser(String email);
    UserEntity createUser(UserPostDto userPostDto);

}
