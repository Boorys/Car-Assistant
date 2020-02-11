package com.car.asistant.demo.service.impl;


import com.car.asistant.demo.entity.CarModelEntity;
import com.car.asistant.demo.exception.ModelExistException;
import com.car.asistant.demo.kit.Utils;
import com.car.asistant.demo.mapper.CarModelMapper;
import com.car.asistant.demo.repository.CarModelRepository;
import com.car.asistant.demo.repository.CarUserRepository;
import com.car.asistant.demo.request.CarModelPostDto;
import com.car.asistant.demo.response.CarModelFullGetDto;
import com.car.asistant.demo.response.CarModelGetDto;
import com.car.asistant.demo.service.CarModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarModelServiceImpl implements CarModelService {

    private CarModelRepository carModelRepository;
    private CarModelMapper carModelMapper;
    private Utils utils;
    private CarUserRepository carUserRepository;

    @Autowired
    public CarModelServiceImpl(CarModelRepository carModelRepository, CarModelMapper carModelMapper, Utils utils, CarUserRepository carUserRepository) {
        this.carModelRepository = carModelRepository;
        this.carModelMapper = carModelMapper;
        this.utils = utils;
        this.carUserRepository = carUserRepository;
    }

    @Override
    public CarModelEntity createCarModel(CarModelPostDto carModelPostDto) {

        CarModelEntity carModelEntity;
        carModelEntity = carModelRepository.findByModel(carModelPostDto.getModel());
        if (carModelEntity != null) {
            throw new ModelExistException(carModelPostDto.getModel());
        }
        carModelEntity = new CarModelEntity();
        carModelEntity = carModelMapper.carModelPostDtoToCarModelEntity(carModelPostDto);
        String carModelId = utils.generateUserId(10);
        carModelEntity.setCarModelId(carModelId);
        carModelRepository.save(carModelEntity);


        return carModelEntity;
    }

    @Override
    public List<CarModelFullGetDto> getAllCarModel() {

        List<CarModelEntity> carModelEntities = new ArrayList<>();
        List<CarModelFullGetDto> carModelDtos = new ArrayList<>();
        CarModelFullGetDto carModelDto;
        carModelEntities = carModelRepository.findAll();

        for (CarModelEntity carModelEntity : carModelEntities) {
            carModelDto = carModelMapper.carModelEntityToCarModelDto(carModelEntity);
            carModelDtos.add(carModelDto);
        }

        return carModelDtos;
    }

    @Override
    public List<CarModelGetDto> getCarModel(String userId) {

        List<Object[]> list = new ArrayList();
        list = carModelRepository.findCarModelByUserId(userId);
        List<CarModelGetDto> carModel = list.stream().map(x -> new CarModelGetDto(x[1].toString(), x[0].toString(), x[2].toString())).collect(Collectors.toList());

        return carModel;
    }

}
