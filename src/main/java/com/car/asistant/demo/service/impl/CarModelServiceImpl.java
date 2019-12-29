package com.car.asistant.demo.service.impl;


import com.car.asistant.demo.dto.CarModelDto;
import com.car.asistant.demo.entity.CarModelEntity;
import com.car.asistant.demo.entity.CarUserEntity;
import com.car.asistant.demo.kit.Utils;
import com.car.asistant.demo.mapper.CarModelMapper;
import com.car.asistant.demo.repository.CarModelRepository;
import com.car.asistant.demo.repository.CarUserRepository;
import com.car.asistant.demo.service.CarModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public CarModelDto createCarModel(CarModelDto carModelDto) {

        CarUserEntity carUserEntity = new CarUserEntity();
        carUserEntity = carUserRepository.findByCarUserId(carModelDto.getCarUserId());
        List<CarUserEntity> carUserEntities = new ArrayList<>();
        carUserEntities.add(carUserEntity);


        String publicCarModelId = utils.generateUserId(30);
        CarModelEntity carModelEntity = new CarModelEntity();

        carModelDto.setCarModelId(publicCarModelId);

        carModelEntity = carModelMapper.carModelDtoToCarModelEntity(carModelDto);

        carModelEntity.setCarsUser(carUserEntities);
        carModelRepository.save(carModelEntity);
        carUserEntity.setCarModel(carModelEntity);
        carUserRepository.save(carUserEntity);


        return carModelDto;
    }

    @Override
    public List<CarModelDto> getAllCarModel(int page, int limit) {

        List<CarModelDto> carModelDtoList = new ArrayList<>();
        CarModelDto carModelDto = new CarModelDto();
        Pageable pagableRequest = PageRequest.of(page, limit);
        Page<CarModelEntity> carModelEntityPage = carModelRepository.findAll(pagableRequest);
        List<CarModelEntity> carsModel = carModelEntityPage.getContent();

        for (CarModelEntity carModelEntity : carsModel) {
            carModelDto = carModelMapper.carModelEntityToCarModelDto(carModelEntity);
            carModelDtoList.add(carModelDto);
        }

        return carModelDtoList;
    }
}
