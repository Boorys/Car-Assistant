package com.car.asistant.demo.mapper;


import com.car.asistant.demo.entity.CarModelEntity;
import com.car.asistant.demo.request.CarModelPostDto;
import com.car.asistant.demo.response.CarModelFullGetDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring")
public interface CarModelMapper {



    CarModelFullGetDto carModelEntityToCarModelDto(CarModelEntity carModelEntity);

    CarModelEntity carModelFullGetDtoToCarModelEntity(CarModelFullGetDto carModelDto);

    @Mappings({
            @Mapping(target = "carBrand", source = "carBrand"),
            @Mapping(target = "model", source = "model"),
            @Mapping(target = "brakePads", source = "brakePads")
    })
    CarModelEntity carModelPostDtoToCarModelEntity(CarModelPostDto carModelPostDto);


}
