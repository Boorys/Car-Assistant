package com.car.asistant.demo.service.impl;

import com.car.asistant.demo.dto.CarUserDto;
import com.car.asistant.demo.dto.UserDto;
import com.car.asistant.demo.entity.UserEntity;
import com.car.asistant.demo.kit.Utils;
import com.car.asistant.demo.mapper.UserMapper;
import com.car.asistant.demo.repository.UserRepository;
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



    public UserServiceImpl(){}

    @Override
    public UserDto getUser(String email) {

        UserEntity userEntity = userRepository.findByEmail(email);
        if (userEntity == null) throw new UsernameNotFoundException(email);

        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(userEntity, returnValue);

        return returnValue;
    }

    @Override
    public UserDto createUser(UserDto userDto) {

        UserEntity userEntity = new UserEntity();

        userEntity = userMapper.userDtoToUserEntity(userDto);
        UserDto savedUserDto = new UserDto();
        UserEntity savedUserEntity = new UserEntity();
      String Password = bCryptPasswordEncoder.encode(userDto.getPassword());
        userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        String publicUserId = utils.generateUserId(30);
        userEntity.setUserId(publicUserId);

        savedUserEntity = userRepository.save(userEntity);
        savedUserDto = userMapper.userEntityToUserDto(savedUserEntity);
        return savedUserDto;
    }

    @Override
    public UserDto getUserByUserId(String userId) {
        UserDto userDto = new UserDto();
        UserEntity userEntity = userRepository.findByUserId(userId);
        if(userEntity == null) throw new UsernameNotFoundException(userId);
        List<CarUserDto> list = new ArrayList<>();
        userDto = userMapper.userEntityToUserDto(userEntity);

        return userDto;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserEntity userEntity = userRepository.findByEmail(email);


        if (userEntity == null) throw new UsernameNotFoundException(email);
        return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), new ArrayList<>());


    }
}
