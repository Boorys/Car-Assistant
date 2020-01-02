package com.car.asistant.demo.mapper;

import com.car.asistant.demo.dto.CarModelDto;
import com.car.asistant.demo.entity.CarModelEntity;
import com.car.asistant.demo.request.CarModelRequestModel;
import com.car.asistant.demo.response.CarModelRest;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;


@Mapper(componentModel = "spring")
public interface CarModelMapper {

    CarModelRest carModelDtoToCarModelRest(CarModelDto carModelDto);

    CarModelDto carModelEntityToCarModelDto(CarModelEntity carModelEntity);

    CarModelDto carModelRequestModelToCarModelDto(CarModelRequestModel carModelRequestModel);

    CarModelEntity carModelDtoToCarModelEntity(CarModelDto carModelDto);

}
