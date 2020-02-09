package com.car.asistant.demo.service.impl;


import com.car.asistant.demo.entity.UserEntity;
import com.car.asistant.demo.kit.Utils;
import com.car.asistant.demo.mapper.UserMapper;
import com.car.asistant.demo.repository.UserRepository;
import com.car.asistant.demo.request.UserPostDto;
import com.car.asistant.demo.response.CarUserDto;
import com.car.asistant.demo.response.UserGetDto;
import com.car.asistant.demo.response.UserSimpleGetDto;
import com.car.asistant.demo.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;
    private UserMapper userMapper;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private Utils utils;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, BCryptPasswordEncoder bCryptPasswordEncoder, Utils utils) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.utils = utils;
    }


    public UserServiceImpl() {
    }

    @Override
    public UserGetDto getUser(String email) {

        UserEntity userEntity = userRepository.findByEmail(email);
        if (userEntity == null) throw new UsernameNotFoundException(email);

        UserGetDto returnValue = new UserGetDto();
        BeanUtils.copyProperties(userEntity, returnValue);

        return returnValue;
    }


    @Override
    public UserEntity createUser(UserPostDto userPostDto) {


        UserEntity userEntity = new UserEntity();
        userEntity = userMapper.userPostDtoToUserEntity(userPostDto);
        String password = bCryptPasswordEncoder.encode(userPostDto.getPassword());
        userEntity.setEncryptedPassword(password);
        String publicUserId = utils.generateUserId(10);
        userEntity.setUserId(publicUserId);
        userEntity.setRole("USER");
        userRepository.save(userEntity);

        return userEntity;
    }

    @Override
    public UserSimpleGetDto getUserByUserId(String userId) {

        UserEntity userEntity = userRepository.findByUserId(userId);
        UserSimpleGetDto userSimpleGetDto;
        userSimpleGetDto = userMapper.userEntityToUserSimpleGetDto(userEntity);

        return userSimpleGetDto;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserEntity userEntity = userRepository.findByEmail(email);


        if (userEntity == null) throw new UsernameNotFoundException(email);
        return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), new ArrayList<>());


    }
}
