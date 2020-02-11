package com.car.asistant.demo.service;

import com.car.asistant.demo.entity.UserEntity;
import com.car.asistant.demo.request.UserPostDto;
import com.car.asistant.demo.response.UserGetDto;
import com.car.asistant.demo.response.UserSimpleGetDto;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {

    UserGetDto getUser(String email);

    UserEntity createUser(UserPostDto userPostDto) throws Exception;

    UserSimpleGetDto getUserByUserId(String userId);
}
