package com.car.asistant.demo.service;

import com.car.asistant.demo.dto.CarUserDto;
import com.car.asistant.demo.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface CarUserService {

    UserDto createCarUser(CarUserDto carUserDto);

}
