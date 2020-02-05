package com.car.asistant.demo.mapper;


import com.car.asistant.demo.entity.CarUserToInformationEntity;
import com.car.asistant.demo.response.CarUserToInformationDto;
import org.mapstruct.Mapper;



@Mapper(componentModel = "spring")
public interface CarUserToInformationMapper
{
    CarUserToInformationDto carUserToInformationEntityToCarUserToInformationDto(CarUserToInformationEntity carUserToInformationEntity);
}
