package com.car.asistant.demo.controller;


import com.car.asistant.demo.mapper.CarModelMapper;
import com.car.asistant.demo.request.CarModelPostDto;
import com.car.asistant.demo.response.CarModelFullGetDto;
import com.car.asistant.demo.response.CarModelGetDto;
import com.car.asistant.demo.service.CarModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/car-model")
public class CarModelController {

    CarModelService carModelService;

    CarModelMapper carModelMapper;

    public CarModelController() {
    }

    @Autowired
    public CarModelController(CarModelService carModelService, CarModelMapper carModelMapper) {
        this.carModelService = carModelService;
        this.carModelMapper = carModelMapper;
    }

    @PostMapping(path="/addCarModel",consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(value = HttpStatus.CREATED, reason = "Add car model")
    public void createCarModel(@RequestBody CarModelPostDto carModelPostDto) {

        carModelService.createCarModel(carModelPostDto);

    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<CarModelFullGetDto> getCarModel() {

        List<CarModelFullGetDto> carModelDtos = new ArrayList<>();
        carModelDtos = carModelService.getAllCarModel();

        return carModelDtos;
    }

    @GetMapping(path = "/get-model/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<CarModelGetDto> getCarModelForUser(@PathVariable String userId) {

        List<CarModelGetDto> carModelGetDtoList = new ArrayList<>();
        carModelGetDtoList = carModelService.getCarModel(userId);

        return carModelGetDtoList;
    }


}
