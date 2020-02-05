package com.car.asistant.demo.service;


import com.car.asistant.demo.entity.UserEntity;
import com.car.asistant.demo.request.CarUserPostDto;
import org.springframework.stereotype.Service;

@Service
public interface CarUserService {


    UserEntity createCarUser(CarUserPostDto carUserRequestModel, String userId);

}
