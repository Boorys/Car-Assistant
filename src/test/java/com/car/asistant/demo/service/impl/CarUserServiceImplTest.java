package com.car.asistant.demo.service.impl;

import com.car.asistant.demo.entity.CarModelEntity;
import com.car.asistant.demo.entity.CarUserEntity;
import com.car.asistant.demo.kit.Utils;
import com.car.asistant.demo.mapper.CarModelMapper;
import com.car.asistant.demo.mapper.CarUserMapper;
import com.car.asistant.demo.repository.CarModelRepository;
import com.car.asistant.demo.repository.CarUserRepository;
import com.car.asistant.demo.request.CarModelPostDto;
import com.car.asistant.demo.request.CarUserPostDto;
import com.car.asistant.demo.request.CarUserPutDto;
import com.car.asistant.demo.service.CarModelService;
import com.car.asistant.demo.service.CarUserService;
import org.junit.Before;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import com.car.asistant.demo.entity.UserEntity;
import com.car.asistant.demo.exception.UserExistException;
import com.car.asistant.demo.kit.Utils;
import com.car.asistant.demo.kit.VerificationToken;
import com.car.asistant.demo.kit.VerivicationMessage;
import com.car.asistant.demo.mapper.UserMapper;
import com.car.asistant.demo.repository.UserRepository;
import com.car.asistant.demo.request.UserPostDto;
import com.car.asistant.demo.response.UserGetDto;
import com.car.asistant.demo.service.SendMessageService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;


@ExtendWith(MockitoExtension.class)
public class CarUserServiceImplTest {

    @Mock
    private CarUserRepository carUserRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private UserMapper userMapper;
    @Mock
    private CarUserMapper carUserMapper;
    @Mock
    private Utils utils;
    @Mock
    private CarModelRepository carModelRepository;
    @Spy
    @InjectMocks
    private CarUserServiceImpl carUserService;


    @Test
    public void createCarShouldShouldCreationTest() {
        //given
        CarUserPostDto carUserPostDto = new CarUserPostDto();
        carUserPostDto.setCarModelId("carModelId");
        carUserPostDto.setCarMilages(10);
        given(carModelRepository.findByCarModelId(anyString())).willReturn(new CarModelEntity());
        given(carUserMapper.carUserPostDtoToCarUserEntity(any(CarUserPostDto.class))).willReturn(new CarUserEntity());
        given(userRepository.findByUserId(anyString())).willReturn(new UserEntity());


        //when
        UserEntity userEntity = carUserService.createCarUser(carUserPostDto, "userId");
        List<CarUserEntity> carUserEntities = userEntity.getCarsUser();
        //then
        assertThat(carUserEntities.get(0).getClass(), equalTo(CarUserEntity.class));

    }

    @Test
    public void updateCarUserShouldUpdate() {
        //given
        String carUserId = "userId";
        CarUserPutDto carUserPutDto = new CarUserPutDto();
        carUserPutDto.setCarMilages(10);
        carUserPutDto.setKilometersSinceTheLastChangeBraekPads(10);
        carUserPutDto.setKilometersSinceTheLastChangeTimingGear(10);
        carUserPutDto.setCarMilages(10);
        carUserPutDto.setKilometersSinceTheLastChangeOil(10);
        carUserPutDto.setNumberOfKilomentersPerMonth(10);
        CarUserEntity carUserEntity = new CarUserEntity();
        carUserEntity.setCarMilages(50);
        given(carUserRepository.findByCarUserId(carUserId)).willReturn(carUserEntity);

        //when
        CarUserEntity carUserEntityUpdated = carUserService.updateCarUser(carUserId, carUserPutDto);


        //then
        assertThat(carUserEntityUpdated.getCarMilages(), equalTo(carUserEntity.getCarMilages()));

    }

}
