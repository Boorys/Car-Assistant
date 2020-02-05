package com.car.asistant.demo.mapper;

import com.car.asistant.demo.entity.CarUserEntity;
import com.car.asistant.demo.request.CarUserPostDto;
import com.car.asistant.demo.response.CarUserDto;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface CarUserMapper {


    CarUserEntity carUserDtoToCarUserEntity(CarUserDto carUserDto);


    CarUserEntity carUserPostDtoToCarUserEntity(CarUserPostDto carUserPostDto);

}
