package com.car.asistant.demo.service.impl;

import com.car.asistant.demo.dto.CarUserDto;
import com.car.asistant.demo.dto.UserDto;
import com.car.asistant.demo.entity.CarUserEntity;
import com.car.asistant.demo.entity.UserEntity;
import com.car.asistant.demo.kit.Utils;
import com.car.asistant.demo.mapper.CarUserMapper;
import com.car.asistant.demo.mapper.UserMapper;
import com.car.asistant.demo.repository.CarModelRepository;
import com.car.asistant.demo.repository.CarUserRepository;
import com.car.asistant.demo.repository.UserRepository;
import com.car.asistant.demo.service.CarUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarUserServiceImpl implements CarUserService {


    private CarUserRepository carUserRepository;
    private UserRepository userRepository;
    private UserMapper userMapper;
    private CarUserMapper carUserMapper;
    private Utils utils;
    private CarModelRepository carModelRepository;


    @Autowired
    public CarUserServiceImpl(CarUserRepository carUserRepository, UserRepository userRepository, UserMapper userMapper,
                              CarUserMapper carUserMapper, Utils utils, CarModelRepository carModelRepository) {
        this.carUserRepository = carUserRepository;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.carUserMapper = carUserMapper;
        this.utils = utils;
        this.carModelRepository = carModelRepository;

    }

    @Override
    public UserDto createCarUser(CarUserDto carUserDto) {

        UserEntity userEntity = new UserEntity();
        userEntity = userRepository.findByUserId(carUserDto.getUserId());

        String publicCarUserId = utils.generateUserId(30);
        carUserDto.setCarUserId(publicCarUserId);
        CarUserEntity carUserEntity = new CarUserEntity();
        List<CarUserEntity> list = new ArrayList<>();


        carUserEntity = carUserMapper.carUserDtoToCarUserEntity(carUserDto);
        list.add(carUserEntity);
        userEntity.setCarsUser(list);
        carUserEntity.setUser(userEntity);
        userEntity = userRepository.save(userEntity);
        UserDto returnedUserDto = new UserDto();
        returnedUserDto = userMapper.userEntityToUserDto(userEntity);


        return returnedUserDto;
    }


}
