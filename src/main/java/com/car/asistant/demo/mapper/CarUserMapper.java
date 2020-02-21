package com.car.asistant.demo.mapper;

import com.car.asistant.demo.entity.CarUserEntity;
import com.car.asistant.demo.request.CarUserPostDto;
import com.car.asistant.demo.request.CarUserPutDto;
import com.car.asistant.demo.response.CarUserDto;
import com.car.asistant.demo.response.CarUserGetDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring")
public interface CarUserMapper {

    CarUserEntity carUserDtoToCarUserEntity(CarUserDto carUserDto);
    CarUserEntity carUserPostDtoToCarUserEntity(CarUserPostDto carUserPostDto);

    CarUserGetDto carUserEntityDtoToCarUserDto(CarUserEntity carUserEntity);




}

