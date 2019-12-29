package com.car.asistant.demo.service;

import com.car.asistant.demo.dto.CarModelDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarModelService
{
    CarModelDto createCarModel(CarModelDto carModelDto);
    List<CarModelDto> getAllCarModel(int page, int limit);

}
