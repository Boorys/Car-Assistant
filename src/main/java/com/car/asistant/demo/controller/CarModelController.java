package com.car.asistant.demo.controller;

import com.car.asistant.demo.dto.CarModelDto;
import com.car.asistant.demo.mapper.CarModelMapper;
import com.car.asistant.demo.request.CarModelRequestModel;
import com.car.asistant.demo.response.CarModelRest;
import com.car.asistant.demo.service.CarModelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/car-model")
public class CarModelController {

    CarModelService carModelService;

    CarModelMapper carModelMapper;

    public CarModelController(){}

    @Autowired
    public CarModelController(CarModelService carModelService, CarModelMapper carModelMapper) {
        this.carModelService = carModelService;
        this.carModelMapper = carModelMapper;
    }

    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE}, produces = {
           MediaType.APPLICATION_JSON_VALUE})
    public CarModelRest createCarModel(@RequestBody CarModelRequestModel carModelRequestModel)
    {
        CarModelRest carModelRest = new CarModelRest();
        CarModelDto carModelDto = new CarModelDto();
        carModelDto = carModelMapper.carModelRequestModelToCarModelDto(carModelRequestModel);
        CarModelDto carModelDtoCreated = new CarModelDto();
        carModelDtoCreated = carModelService.createCarModel(carModelDto);
        carModelRest = carModelMapper.carModelDtoToCarModelRest(carModelDtoCreated);

        return carModelRest;
    }

    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE})
    public List<CarModelRest> getUser() {

        List<CarModelRest> carModelRestList = new ArrayList<>();
        List<CarModelDto> carModelDtoList = new ArrayList<>();
        carModelDtoList.addAll(carModelService.getAllCarModel(0, 10));
        for (CarModelDto carModelDto : carModelDtoList) {
            carModelRestList.add(carModelMapper.carModelDtoToCarModelRest(carModelDto));
        }

        return carModelRestList;
    }

}
