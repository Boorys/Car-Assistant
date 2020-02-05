package com.car.asistant.demo.service;


import com.car.asistant.demo.entity.CarUserEntity;
import com.car.asistant.demo.entity.UserEntity;
import com.car.asistant.demo.kit.Utils;
import com.car.asistant.demo.mapper.CarUserMapper;
import com.car.asistant.demo.mapper.UserMapper;
import com.car.asistant.demo.repository.CarModelRepository;
import com.car.asistant.demo.repository.CarUserRepository;
import com.car.asistant.demo.repository.UserRepository;
import com.car.asistant.demo.service.impl.CarUserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CarUserServiceTest {

    CarUserRepository carUserRepository;
    UserRepository userRepository;
    UserMapper userMapper;
    CarUserMapper carUserMapper;
    Utils utils;
    CarModelRepository carModelRepository;
    CarUserServiceImpl carUserService;

    @Before
    public void init() {
        carUserRepository = mock(CarUserRepository.class);
        userRepository = mock(UserRepository.class);
        userMapper = mock(UserMapper.class);
        carUserMapper = mock(CarUserMapper.class);
        utils = mock(Utils.class);
        carModelRepository = mock(CarModelRepository.class);
        carUserService = spy(new CarUserServiceImpl(carUserRepository, userRepository, userMapper, carUserMapper, utils, carModelRepository));
    }

    @Test
    public void createCarUserTest() {
  /*      String userId = "id";
        CarUserDto carUserDto = new CarUserDto();
        carUserDto.setUserId(userId);
        carUserDto.setCarUserId("");
        UserEntity userEntity = new UserEntity();
        CarUserEntity carUserEntity = new CarUserEntity();
        UserDto userDto = new UserDto();
        userDto.setUserId(userId);

        when(userRepository.findByUserId(anyString())).thenReturn(userEntity);
        when(utils.generateUserId(anyInt())).thenReturn("");
        when(carUserMapper.carUserDtoToCarUserEntity(carUserDto)).thenReturn(carUserEntity);
        when(userRepository.save(userEntity)).thenReturn(userEntity);
        when(userMapper.userEntityToUserDto(userEntity)).thenReturn(userDto);
    //    Assert.assertEquals(carUserService.createCarUser(carUserDto).getUserId(), userId);
*/
    }


}
