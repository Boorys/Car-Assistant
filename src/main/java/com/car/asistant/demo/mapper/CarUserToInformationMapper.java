package com.car.asistant.demo.mapper;

import com.car.asistant.demo.dto.CarUserToInformationDto;
import com.car.asistant.demo.entity.CarUserToInformationEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarUserToInformationMapper
{
    CarUserToInformationDto carUserToInformationEntityToCarUserToInformationDto(CarUserToInformationEntity carUserToInformationEntity);
}
