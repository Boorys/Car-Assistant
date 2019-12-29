package com.car.asistant.demo.mapper;

import com.car.asistant.demo.dto.CarUserDto;
import com.car.asistant.demo.entity.CarUserEntity;
import com.car.asistant.demo.request.CarUserRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface CarUserMapper {


    CarUserEntity carUserDtoToCarUserEntity(CarUserDto carUserDto);

    @Mappings({
            @Mapping(target = "carModelId", source = "carUserEntity.carModel.id"),
            @Mapping(target = "userId", source = "carUserEntity.carUserId")
    })
    CarUserDto carUserEntityToCarUserDto(CarUserEntity carUserEntity);


    CarUserDto carUserRequestModelToCarUserDto(CarUserRequestModel carUserRequestModel);
}
