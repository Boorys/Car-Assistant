package com.car.asistant.demo.service;


import com.car.asistant.demo.entity.CarModelEntity;
import com.car.asistant.demo.request.CarModelPostDto;
import com.car.asistant.demo.response.CarModelFullGetDto;
import com.car.asistant.demo.response.CarModelGetDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarModelService
{
    CarModelEntity createCarModel(CarModelPostDto carModelPostDto);
   List<CarModelFullGetDto> getAllCarModel();
    List<CarModelGetDto> getCarModel(String userId);
}
