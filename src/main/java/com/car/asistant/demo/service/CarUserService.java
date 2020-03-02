package com.car.asistant.demo.service;


import com.car.asistant.demo.entity.CarUserEntity;
import com.car.asistant.demo.entity.UserEntity;
import com.car.asistant.demo.request.CarUserPostDto;
import com.car.asistant.demo.request.CarUserPutDto;
import com.car.asistant.demo.response.CarUserGetDto;
import org.springframework.stereotype.Service;

@Service
public interface CarUserService {


    UserEntity createCarUser(CarUserPostDto carUserRequestModel, String userId);

    void deleteCarUser(String carUserId);

    CarUserEntity updateCarUser(String carUserId, CarUserPutDto carUserPutDto);

    CarUserGetDto getCarUser(String carUserId);
}
