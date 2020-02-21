package com.car.asistant.demo.service.impl;


import com.car.asistant.demo.entity.CarModelEntity;
import com.car.asistant.demo.entity.CarUserEntity;
import com.car.asistant.demo.entity.UserEntity;
import com.car.asistant.demo.kit.Utils;
import com.car.asistant.demo.mapper.CarUserMapper;
import com.car.asistant.demo.mapper.UserMapper;
import com.car.asistant.demo.repository.CarModelRepository;
import com.car.asistant.demo.repository.CarUserRepository;
import com.car.asistant.demo.repository.UserRepository;
import com.car.asistant.demo.request.CarUserPostDto;
import com.car.asistant.demo.request.CarUserPutDto;
import com.car.asistant.demo.response.CarUserGetDto;
import com.car.asistant.demo.service.CarUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public UserEntity createCarUser(CarUserPostDto carUserPostDto, String userId) {

        UserEntity userEntity = new UserEntity();
        CarModelEntity carModelEntity = new CarModelEntity();
        CarUserEntity carUserEntity = new CarUserEntity();

        carModelEntity = carModelRepository.findByCarModelId(carUserPostDto.getCarModelId());

        carUserEntity = carUserMapper.carUserPostDtoToCarUserEntity(carUserPostDto);

        userEntity = userRepository.findByUserId(userId);
        carUserEntity.setCarUserId(utils.generateUserId(10));
        carUserEntity.setCarModel(carModelEntity);
        List<CarUserEntity> list = new ArrayList<>();
        list.add(carUserEntity);
        userEntity.setCarsUser(list);
        carUserEntity.setUser(userEntity);
        carUserRepository.save(carUserEntity);
        userRepository.save(userEntity);

        return userEntity;
    }

    @Transactional
    @Override
    public void deleteCarUser(String carUserId) {

        carUserRepository.deleteByCarUserId(carUserId);
    }

    @Override
    public void updateCarUser(String carUserId, CarUserPutDto carUserPutDto) {

        CarUserEntity carUserEntity = carUserRepository.findByCarUserId(carUserId);
        carUserEntity.setCarMilages(carUserPutDto.getCarMilages());
        carUserEntity.setNumberOfKilomentersPerMonth(carUserPutDto.getNumberOfKilomentersPerMonth());
        carUserEntity.setKilometersSinceTheLastChangeBraekPads(carUserPutDto.getKilometersSinceTheLastChangeBraekPads());
        carUserEntity.setKilometersSinceTheLastChangeOil(carUserPutDto.getKilometersSinceTheLastChangeOil());
        carUserEntity.setKilometersSinceTheLastChangeTimingGear(carUserPutDto.getKilometersSinceTheLastChangeTimingGear());

        carUserRepository.save(carUserEntity);

    }

    @Override
    public CarUserGetDto getCarUser(String carUserId) {

        CarUserEntity carUserEntity = carUserRepository.findByCarUserId(carUserId);
        CarUserGetDto carUserGetDto = carUserMapper.carUserEntityDtoToCarUserDto(carUserEntity);


        return carUserGetDto;
    }


}
