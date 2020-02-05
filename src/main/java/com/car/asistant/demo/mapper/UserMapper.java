package com.car.asistant.demo.mapper;



import com.car.asistant.demo.entity.UserEntity;
import com.car.asistant.demo.request.UserPostDto;
import com.car.asistant.demo.response.UserGetDto;
import org.mapstruct.Mapper;



@Mapper(componentModel = "spring")
public interface UserMapper {

    UserGetDto userEntityToUserDto(UserEntity userEntity);

    UserEntity userGetDtoToUserEntity(UserGetDto userGetDto);

    UserEntity userPostDtoToUserEntity(UserPostDto userPostDto);
}
