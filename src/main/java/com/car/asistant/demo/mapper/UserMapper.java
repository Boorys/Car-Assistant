package com.car.asistant.demo.mapper;



import com.car.asistant.demo.dto.UserDto;
import com.car.asistant.demo.entity.UserEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;


@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto userEntityToUserDto(UserEntity userEntity);
    UserEntity userDtoToUserEntity(UserDto userDto);

}
